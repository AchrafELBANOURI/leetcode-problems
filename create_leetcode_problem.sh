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
import shared.utilities.TestUtils;

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

# 6. Create the Jupyter notebook solution file
cat > "$DATE_FOLDER/$PROBLEM_FOLDER/python/solution.ipynb" << 'EOF'
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
    "from typing import List\n",
    "\n",
    "class Solution:\n",
    "    # TODO: Implement Your Solution Here\n",
    "    pass\n",
    "\n",
    "def assert_test(expected: str, actual: str, test_name: str):\n",
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
    "sol = Solution()\n",
    "input_data = None\n",
    "output = None\n",
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
    "sol = Solution()\n",
    "input_data = None\n",
    "output = None\n",
    "expected = None\n",
    "assert_test(expected, output, \"Test Case 2\")"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 3:**"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": [
    "sol = Solution()\n",
    "input_data = None\n",
    "output = None\n",
    "expected = None\n",
    "assert_test(expected, output, \"Test Case 3\")"
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

Located in [\`python/solution.ipynb\`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- Time Complexity:
- Space Complexity:

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
EOF

echo "Created LeetCode problem structure at $DATE_FOLDER/$PROBLEM_FOLDER"
echo "Created Java solution at $TARGET_JAVA_DIR/Solution.java (package: $PACKAGE_NAME)"
echo "Added '$NEW_SOURCE_PATH' to .vscode/settings.json"