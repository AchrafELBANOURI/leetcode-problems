#!/bin/bash

# Check if a problem title was provided
if [ -z "$1" ]; then
    echo "Please provide a problem title"
    echo "Usage: ./create_leetcode_problem.sh \"Problem Title\""
    exit 1
fi

RAW_TITLE="$1"

# 1. Main problem directory uses hyphens (e.g., "Range-Sum-Query-2D---Immutable")
DATE_FOLDER=$(date +%Y-%m-%d)
PROBLEM_FOLDER="${RAW_TITLE// /-}"  # Replace spaces with hyphens

# 2. Convert problem title to camelCase for the subfolder and package declaration
PACKAGE_NAME=$(echo "$RAW_TITLE" | sed -E 's/[^a-zA-Z0-9 ]//g' | awk '{
    out = tolower($1);
    for (i = 2; i <= NF; i++) {
        out = out toupper(substr($i,1,1)) tolower(substr($i,2));
    }
    print out;
}')

# 3. Create directory structure: main hyphenated folder -> java -> camelCase subfolder
TARGET_JAVA_DIR="$DATE_FOLDER/$PROBLEM_FOLDER/java/$PACKAGE_NAME"
mkdir -p "$TARGET_JAVA_DIR"
mkdir -p "$DATE_FOLDER/$PROBLEM_FOLDER/python"

# 4. Create the Java solution file with camelCase package header
cat > "$TARGET_JAVA_DIR/Solution.java" << EOF
package $PACKAGE_NAME;

import java.util.*;
import utilities.TestUtils;

class Solution {
    // TODO: Implement solution method here
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        // TODO: Add test case 1
        Object input = null;
        Object output = null;
        Object expected = null;

        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
        
        // Test Case 2
        // TODO: Add test case 2
        input = null;
        output = null;
        expected = null;
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 2"
        );
    }
}
EOF

# 5. Automatically update .vscode/settings.json
SETTINGS_FILE=".vscode/settings.json"
NEW_SOURCE_PATH="$DATE_FOLDER/$PROBLEM_FOLDER/java"

if [ -f "$SETTINGS_FILE" ]; then
    # Check if path already exists in settings.json to avoid duplicates
    if ! grep -q "\"$NEW_SOURCE_PATH\"" "$SETTINGS_FILE"; then
        # Append the new source path before the closing array bracket ']'
        sed -i "/\"java.project.sourcePaths\": *\[/a \ \ \ \ \"$NEW_SOURCE_PATH\"," "$SETTINGS_FILE"
    fi
else
    # Create .vscode/settings.json if it doesn't exist yet
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

# 6. Create the Python solution file
cat > "$DATE_FOLDER/$PROBLEM_FOLDER/python/solution.py" << 'EOF'
from typing import List, Any


class Solution:
    # TODO: Implement Your Solution Here
    pass


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # --- Case 1 ---
    input_data_1 = None
    output_1 = None
    expected_1 = None
    assert_test(expected_1, output_1, "Test Case 1")

    # --- Case 2 ---
    input_data_2 = None
    output_2 = None
    expected_2 = None
    assert_test(expected_2, output_2, "Test Case 2")

    # --- Case 3 ---
    input_data_3 = None
    output_3 = None
    expected_3 = None
    assert_test(expected_3, output_3, "Test Case 3")


if __name__ == "__main__":
    main()
EOF

# 7. Create README.md
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

# files location
JAVA_FILE_PATH="$TARGET_JAVA_DIR/Solution.java"
PYTHON_FILE_PATH="$DATE_FOLDER/$PROBLEM_FOLDER/python/solution.py"
README_FILE_PATH="$DATE_FOLDER/$PROBLEM_FOLDER/README.md"

# --- Open Files & Focus Current VS Code Window ---
if command -v code &> /dev/null; then
    # -r reuses the current active window
    # -g focuses and refreshes the editor tabs for these file paths
    code -r -g "$JAVA_FILE_PATH" "$PYTHON_FILE_PATH" "$README_FILE_PATH"
fi


echo "Created LeetCode problem structure at $DATE_FOLDER/$PROBLEM_FOLDER"
echo "Created Java solution at $TARGET_JAVA_DIR/Solution.java (package: $PACKAGE_NAME)"
echo "Added '$NEW_SOURCE_PATH' to .vscode/settings.json"
echo "Update git commit script to git_commits_template.sh"
echo "Opened target files directly in VS Code."