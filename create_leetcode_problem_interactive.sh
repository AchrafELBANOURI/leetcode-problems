#!/bin/bash

# --- Interactive Prompts: Function Signature ---

read -p "Project/Problem Name: " RAW_TITLE
if [ -z "$RAW_TITLE" ]; then
    echo "Error: Problem name cannot be empty."
    exit 1
fi

read -p "Function Name: " FUNC_NAME
read -p "How many arguments: " ARG_COUNT

ARG_NAMES=()
ARG_TYPES_JAVA=()

for ((i=1; i<=ARG_COUNT; i++)); do
    read -p "Argument $i Name: " PARAM_NAME
    read -p "Argument $i Type (Java style, e.g. int[][]): " PARAM_TYPE
    ARG_NAMES+=("$PARAM_NAME")
    ARG_TYPES_JAVA+=("$PARAM_TYPE")
done

read -p "Return Type (Java style, e.g. int): " RETURN_TYPE_JAVA

# --- Interactive Prompts: Code Implementation ---

echo -e "\nEnter Java code implementation (type 'END' on a new line when finished):"
JAVA_CODE=""
while IFS= read -r line; do
    if [ "$line" = "END" ]; then
        break
    fi
    JAVA_CODE+="$line"$'\n'
done

echo -e "\nEnter Python code implementation (type 'END' on a new line when finished):"
PYTHON_CODE=""
while IFS= read -r line; do
    if [ "$line" = "END" ]; then
        break
    fi
    PYTHON_CODE+="$line"$'\n'
done

# --- Helper Formatting Functions ---

java_to_python_type() {
    local t="$1"
    case "$t" in
        int|long|short|byte) echo "int" ;;
        double|float) echo "float" ;;
        boolean) echo "bool" ;;
        String) echo "str" ;;
        int[]|long[]|double[]|String[]|boolean[]) echo "List[${t//\[\]/}]" ;;
        int[][]|long[][]|double[][]|String[][]) echo "List[List[${t//\[\]/}]]" ;;
        *) echo "Any" ;;
    esac
}

format_java_val() {
    local val="$1"
    local type="$2"
    if [[ "$type" == *"[]"* ]]; then
        val="${val//\[/\{}"
        val="${val//\]/\}}"
        if [[ "$val" != "new "* ]] && [[ "$val" != "null" ]]; then
            echo "new $type$val"
            return
        fi
    fi
    echo "$val"
}

format_python_val() {
    local val="$1"
    val="${val//\{/\[}"
    val="${val//\}/\]}"
    val="${val//true/True}"
    val="${val//false/False}"
    val="${val//null/None}"
    echo "$val"
}

# --- Interactive Prompts: Test Cases ---

read -p "How many test cases: " TEST_CASE_COUNT

declare -A TEST_INPUTS
declare -a TEST_EXPECTED

for ((tc=1; tc<=TEST_CASE_COUNT; tc++)); do
    echo -e "\n--- Test Case $tc ---"
    for ((arg=0; arg<ARG_COUNT; arg++)); do
        read -p "Input $((arg+1)) (${ARG_NAMES[$arg]} - ${ARG_TYPES_JAVA[$arg]}): " VAL
        TEST_INPUTS[$tc,$arg]="$VAL"
    done
    read -p "Expected Output ($RETURN_TYPE_JAVA): " EXP_VAL
    TEST_EXPECTED[$tc]="$EXP_VAL"
done

# --- Signature Construction ---

JAVA_PARAMS=""
PYTHON_PARAMS="self"
PYTHON_ARGS=""

for ((i=0; i<ARG_COUNT; i++)); do
    pname="${ARG_NAMES[$i]}"
    ptype_j="${ARG_TYPES_JAVA[$i]}"
    ptype_p=$(java_to_python_type "$ptype_j")

    if [ $i -gt 0 ]; then
        JAVA_PARAMS+=", "
        PYTHON_ARGS+=", "
    fi
    PYTHON_PARAMS+=", "

    JAVA_PARAMS+="$ptype_j $pname"
    PYTHON_PARAMS+="$pname: $ptype_p"
    PYTHON_ARGS+="$pname"
done

PYTHON_RETURN_TYPE=$(java_to_python_type "$RETURN_TYPE_JAVA")

JAVA_DUMMY_RETURN=""
case "$RETURN_TYPE_JAVA" in
    void) JAVA_DUMMY_RETURN="" ;;
    boolean) JAVA_DUMMY_RETURN="return false;" ;;
    int|long|double|float|short|byte|char) JAVA_DUMMY_RETURN="return 0;" ;;
    *) JAVA_DUMMY_RETURN="return null;" ;;
esac

# --- Format Java Method Body ---

if [ -z "$JAVA_CODE" ]; then
    JAVA_METHOD_BODY=$'\t\t// TODO: Implement solution method\n\t'"$JAVA_DUMMY_RETURN"
else
    JAVA_METHOD_BODY=$(echo "$JAVA_CODE")
fi

# --- Format Python Method Body ---
if [ -z "$PYTHON_CODE" ]; then
    PYTHON_METHOD_BODY="        # TODO: Implement Solution Here\n        pass"
else
    # 1. Strip trailing newlines
    # 2. Determine base indentation of line 1 or line 2 (whichever has text)
    # 3. Strip existing top-level indent from all lines, then apply clean 8 spaces
    PYTHON_METHOD_BODY=$(echo "$PYTHON_CODE" | awk '
        NR == 1 && $0 ~ /^[[:space:]]+/ { sub(/^[[:space:]]+/, ""); }
        { print $0 }
    ' | sed 's/^[[:space:]]\{1,4\}//' | sed 's/^/    /')
fi

# --- Directory & Package Naming ---

DATE_FOLDER=$(date +%Y-%m-%d)
PROBLEM_FOLDER="${RAW_TITLE// /-}"

PACKAGE_NAME=$(echo "$RAW_TITLE" | sed -E 's/[^a-zA-Z0-9 ]//g' | awk '{
    out = tolower($1);
    for (i = 2; i <= NF; i++) {
        word = $i;
        low = tolower(word);
        if (low ~ /^[ivxlcdm]+$/) {
            out = out toupper(word);
        } else {
            out = out toupper(substr(word,1,1)) tolower(substr(word,2));
        }
    }
    print out;
}')

TARGET_JAVA_DIR="$DATE_FOLDER/$PROBLEM_FOLDER/java/$PACKAGE_NAME"
mkdir -p "$TARGET_JAVA_DIR"
mkdir -p "$DATE_FOLDER/$PROBLEM_FOLDER/python"

# --- Build Java Test Block Code ---

JAVA_TEST_BLOCKS=""

for ((tc=1; tc<=TEST_CASE_COUNT; tc++)); do
    JAVA_TEST_BLOCKS+="        // Test Case $tc"$'\n'
    JAVA_CALL_ARGS=""
    
    for ((arg=0; arg<ARG_COUNT; arg++)); do
        var_name="${ARG_NAMES[$arg]}_$tc"
        raw_val="${TEST_INPUTS[$tc,$arg]}"
        formatted_val=$(format_java_val "$raw_val" "${ARG_TYPES_JAVA[$arg]}")
        
        JAVA_TEST_BLOCKS+="        ${ARG_TYPES_JAVA[$arg]} $var_name = $formatted_val;"$'\n'
        
        if [ $arg -gt 0 ]; then JAVA_CALL_ARGS+=", "; fi
        JAVA_CALL_ARGS+="$var_name"
    done
    
    exp_formatted=$(format_java_val "${TEST_EXPECTED[$tc]}" "$RETURN_TYPE_JAVA")
    
    JAVA_TEST_BLOCKS+="        $RETURN_TYPE_JAVA output$tc = sol.$FUNC_NAME($JAVA_CALL_ARGS);"$'\n'
    JAVA_TEST_BLOCKS+="        $RETURN_TYPE_JAVA expected$tc = $exp_formatted;"$'\n\n'
    JAVA_TEST_BLOCKS+="        TestUtils.assertTest("$'\n'
    JAVA_TEST_BLOCKS+="            expected$tc, "$'\n'
    JAVA_TEST_BLOCKS+="            output$tc,"$'\n'
    JAVA_TEST_BLOCKS+="            \"Test Case $tc\""$'\n'
    JAVA_TEST_BLOCKS+="        );"$'\n\n'
done

JAVA_FILE_PATH="$TARGET_JAVA_DIR/Solution.java"

cat > "$JAVA_FILE_PATH" << EOF
package $PACKAGE_NAME;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public $RETURN_TYPE_JAVA $FUNC_NAME($JAVA_PARAMS) {
$JAVA_METHOD_BODY
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

$JAVA_TEST_BLOCKS    }
}
EOF

# --- Update .vscode/settings.json ---

SETTINGS_FILE=".vscode/settings.json"
NEW_SOURCE_PATH="$DATE_FOLDER/$PROBLEM_FOLDER/java"

if [ -f "$SETTINGS_FILE" ]; then
    if ! grep -q "\"$NEW_SOURCE_PATH\"" "$SETTINGS_FILE"; then
        sed -i "/\"java.project.sourcePaths\": *\[/a \ \ \ \ \"$NEW_SOURCE_PATH\"," "$SETTINGS_FILE"
    fi
else
    mkdir -p .vscode
    cat > "$SETTINGS_FILE" << EOF
{
  "java.project.sourcePaths": [
    "shared",
    "$NEW_SOURCE_PATH"
  ]
}
EOF
fi

# --- Build Python Test Cases ---

PYTHON_CELLS=""

for ((tc=1; tc<=TEST_CASE_COUNT; tc++)); do
    PY_VAR_LINES=""
    for ((arg=0; arg<ARG_COUNT; arg++)); do
        pname="${ARG_NAMES[$arg]}"
        raw_val="${TEST_INPUTS[$tc,$arg]}"
        formatted_val=$(format_python_val "$raw_val")
        
        # Raw assignment line without JSON quotes or extra escaping
        PY_VAR_LINES+="$pname = $formatted_val"$'\n'
    done

    exp_formatted=$(format_python_val "${TEST_EXPECTED[$tc]}")

# Indent comment and execution statements with tabs
PYTHON_CELLS+="    # Case $tc"$'\n'
PYTHON_CELLS+="    $PY_VAR_LINES"
PYTHON_CELLS+="    output = sol.$FUNC_NAME($PYTHON_ARGS)"$'\n'
PYTHON_CELLS+="    expected = $exp_formatted"$'\n'
PYTHON_CELLS+="    assert_test(expected, output, \"Test Case $tc\")"$'\n\n'
done

# Set path to .py
PYTHON_FILE_PATH="$DATE_FOLDER/$PROBLEM_FOLDER/python/solution.py"

cat > "$PYTHON_FILE_PATH" << EOF
from typing import List, Any


class Solution:
    def $FUNC_NAME($PYTHON_PARAMS) -> $PYTHON_RETURN_TYPE:
$PYTHON_METHOD_BODY


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

$PYTHON_CELLS

if __name__ == "__main__":
    main()
EOF

# --- Create README.md ---

README_FILE_PATH="$DATE_FOLDER/$PROBLEM_FOLDER/README.md"

cat > "$README_FILE_PATH" << EOF
# Daily LeetCode Problem - $(date +"%B %d, %Y")

## Problem

<!-- Add problem link and title here -->

## Problem Statement

<!-- Add problem description here -->

## Solutions

### Java Solution

Located in [\`java/$PACKAGE_NAME/Solution.java\`](java/$PACKAGE_NAME/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- Time Complexity:
- Space Complexity:

### Python Solution

Located in [\`python/solution.py\`](python/solution.py)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- Time Complexity:
- Space Complexity:

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
EOF

# --- Generate git_commits_template.sh ---

GIT_SCRIPT="git_commits_template.sh"

cat > "$GIT_SCRIPT" << EOF
#!/bin/bash

# Auto-generated commits for: $RAW_TITLE ($DATE_FOLDER)

git add "$DATE_FOLDER/$PROBLEM_FOLDER/java/"
git commit -m "feat($PROBLEM_FOLDER): solve $RAW_TITLE problem using java"

git add "$DATE_FOLDER/$PROBLEM_FOLDER/python/"
git commit -m "feat($PROBLEM_FOLDER): solve $RAW_TITLE problem using python"

git add "$DATE_FOLDER/$PROBLEM_FOLDER/"
git commit -m "feat($PROBLEM_FOLDER): add README for $RAW_TITLE problem with problem statement and examples"
EOF

chmod +x "$GIT_SCRIPT"


# --- Open Files & Focus Current VS Code Window ---
if command -v code &> /dev/null; then
    # -r reuses the current active window
    # -g focuses and refreshes the editor tabs for these file paths
    code -r -g "$JAVA_FILE_PATH" "$PYTHON_FILE_PATH" "$README_FILE_PATH"
fi

echo "--------------------------------------------------"
echo "Successfully generated files for: $RAW_TITLE"
echo "Generated $TEST_CASE_COUNT fully configured test case(s)."
echo "Java path: $JAVA_FILE_PATH"
echo "Python path: $PYTHON_FILE_PATH"
echo "Update git commit script to git_commits_template.sh"
echo "Added '$NEW_SOURCE_PATH' to .vscode/settings.json"
echo "Opened target files directly in VS Code."