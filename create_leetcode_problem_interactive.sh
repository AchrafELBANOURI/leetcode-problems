#!/bin/bash

# --- Interactive Prompts ---

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

# --- Helper Formatting Functions ---

# Convert Java types to Python typing hints
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

# Construct Java parameter list: "int[][] matrix, int row1, int col1"
JAVA_PARAMS=""
# Construct Python parameter list: "self, matrix: List[List[int]], row1: int"
PYTHON_PARAMS="self"
# Construct Python argument list for function call: "arg1, arg2"
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

# Set dummy return statement for Java template
JAVA_DUMMY_RETURN=""
case "$RETURN_TYPE_JAVA" in
    void) JAVA_DUMMY_RETURN="" ;;
    boolean) JAVA_DUMMY_RETURN="return false;" ;;
    int|long|double|float|short|byte|char) JAVA_DUMMY_RETURN="return 0;" ;;
    *) JAVA_DUMMY_RETURN="return null;" ;;
esac

# --- Directory & Package Naming ---

DATE_FOLDER=$(date +%Y-%m-%d)
PROBLEM_FOLDER="${RAW_TITLE// /-}"  # Replace spaces with hyphens

# Convert title to camelCase for subfolder and package declaration
PACKAGE_NAME=$(echo "$RAW_TITLE" | sed -E 's/[^a-zA-Z0-9 ]//g' | awk '{
    out = tolower($1);
    for (i = 2; i <= NF; i++) {
        out = out toupper(substr($i,1,1)) tolower(substr($i,2));
    }
    print out;
}')

TARGET_JAVA_DIR="$DATE_FOLDER/$PROBLEM_FOLDER/java/$PACKAGE_NAME"
mkdir -p "$TARGET_JAVA_DIR"
mkdir -p "$DATE_FOLDER/$PROBLEM_FOLDER/python"

# --- Create Java Solution File ---

# --- Generate Test Case 1 Variables ---
JAVA_TEST_VARS_1=""
for ((i=0; i<ARG_COUNT; i++)); do
    JAVA_TEST_VARS_1+="${ARG_TYPES_JAVA[$i]} ${ARG_NAMES[$i]}_1 = null;"$'\n'
done

# --- Generate Test Case 2 Variables ---
JAVA_TEST_VARS_2=""
for ((i=0; i<ARG_COUNT; i++)); do
    JAVA_TEST_VARS_2+="${ARG_TYPES_JAVA[$i]} ${ARG_NAMES[$i]}_2 = null;"$'\n'
done

# --- Construct Java Function Arguments for Call ---
JAVA_ARGS_1=""
JAVA_ARGS_2=""
for ((i=0; i<ARG_COUNT; i++)); do
    if [ $i -gt 0 ]; then
        JAVA_ARGS_1+=", "
        JAVA_ARGS_2+=", "
    fi
    JAVA_ARGS_1+="${ARG_NAMES[$i]}_1"
    JAVA_ARGS_2+="${ARG_NAMES[$i]}_2"
done

cat > "$TARGET_JAVA_DIR/Solution.java" << EOF
package $PACKAGE_NAME;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public $RETURN_TYPE_JAVA $FUNC_NAME($JAVA_PARAMS) {
        // TODO: Implement solution method
        $JAVA_DUMMY_RETURN
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        $(echo -e "$JAVA_TEST_VARS_1")        
        $RETURN_TYPE_JAVA output1 = sol.$FUNC_NAME($JAVA_ARGS_1);
        $RETURN_TYPE_JAVA expected1 = null;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );
        
        // Test Case 2
        $(echo -e "$JAVA_TEST_VARS_2")        
        $RETURN_TYPE_JAVA output2 = sol.$FUNC_NAME($JAVA_ARGS_2);
        $RETURN_TYPE_JAVA expected2 = null;
        
        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );
    }
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

# --- Create Jupyter Notebook File ---

PYTHON_TEST_VARS=""
for ((i=0; i<ARG_COUNT; i++)); do
    PYTHON_TEST_VARS+="\\n${ARG_NAMES[$i]} = None"
done

cat > "$DATE_FOLDER/$PROBLEM_FOLDER/python/solution.ipynb" << EOF
{
 "cells": [
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "## **Setup & Solution Code:**"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": [
    "from typing import List, Any\n",
    "\n",
    "class Solution:\n",
    "    def $FUNC_NAME($PYTHON_PARAMS) -> $PYTHON_RETURN_TYPE:\n",
    "        # TODO: Implement Solution Here\n",
    "        pass\n",
    "\n",
    "def assert_test(expected: Any, actual: Any, test_name: str):\n",
    "   if expected == actual:\n",
    "       print(f\"PASS: {test_name}\")\n",
    "   else:\n",
    "       print(f\"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'\")"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 1:**"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": [
    "sol = Solution()$PYTHON_TEST_VARS\n",
    "output = sol.$FUNC_NAME($PYTHON_ARGS)\n",
    "expected = None\n",
    "assert_test(expected, output, \"Test Case 1\")"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 2:**"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": [
    "sol = Solution()$PYTHON_TEST_VARS\n",
    "output = sol.$FUNC_NAME($PYTHON_ARGS)\n",
    "expected = None\n",
    "assert_test(expected, output, \"Test Case 2\")"
   ]
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.12.3"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 4
}
EOF

# --- Create README.md ---

cat > "$DATE_FOLDER/$PROBLEM_FOLDER/README.md" << EOF
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

Located in [\`python/solution.ipynb\`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- Time Complexity:
- Space Complexity:

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
EOF

echo "--------------------------------------------------"
echo "Successfully generated files for: $RAW_TITLE"
echo "Java path: $TARGET_JAVA_DIR/Solution.java"
echo "Python path: $DATE_FOLDER/$PROBLEM_FOLDER/python/solution.ipynb"
echo "Added '$NEW_SOURCE_PATH' to .vscode/settings.json"