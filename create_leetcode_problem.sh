#!/bin/bash

# Check if a problem title was provided
if [ -z "$1" ]; then
    echo "Please provide a problem title"
    echo "Usage: ./create_leetcode_problem.sh \"Problem Title\""
    exit 1
fi

# Create the date folder (YYYY-MM-DD format)
DATE_FOLDER=$(date +%Y-%m-%d)
PROBLEM_FOLDER="${1// /-}"  # Replace spaces with hyphens

# Create the directory structure
mkdir -p "$DATE_FOLDER/$PROBLEM_FOLDER"/{java,python}

# Create the Java solution file
cat > "$DATE_FOLDER/$PROBLEM_FOLDER/java/Solution.java" << 'EOF'
import java.util.*;
import utilities.TestUtils;

class Solution {
    // TODO: Implement solution method here
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        // TODO: Add test case 1
        Object input = null ;
        Object output = null ;
        Object expected = null ;

        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
        
        // Test Case 2
        // TODO: Add test case 2
        input = null;
        output = null;
        expected = null 
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 2"
        );
        
    }
}
EOF

# Create the Jupyter notebook solution file
cat > "$DATE_FOLDER/$PROBLEM_FOLDER/python/solution.ipynb" << EOF
{
 "cells": [
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "## **Solution Code :**"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "source": [

   "def assert_test(expected, actual, test_name: str):\\n",
   "    if expected == actual:\\n",
   "        print(f"PASS: {test_name}")\n",
   "    else:\\n",
   "        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")\\n",
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 1 :**  \\n"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "source": [
    "# Test CASE 1\\n",
    "input = None\\n",
    "output = None\\n",
    "expected = None\\n",
    "assertTest(expected,output,"Test Case 1")"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 2 :**  \\n"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "source": [
    "# Test CASE 2\\n",
    "input = None\\n",
    "output = None\\n",
    "expected = None\\n",
    "assertTest(expected,output,"Test Case 2")
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 3 :**  \\n"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "source": [
    "# Test CASE 3\\n",
    "input = None\\n",
    "output = None\\n",
    "expected = None\\n",
    "assertTest(expected,output,"Test Case 3")
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

# Create README.md with default content
cat > "$DATE_FOLDER/$PROBLEM_FOLDER/README.md" << 'EOF'
# Daily LeetCode Problem - $(date +%B\ %d,\ %Y)

## Problem

<!-- Add problem link and title here -->

## Problem Statement

<!-- Add problem description here -->

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- Time Complexity:
- Space Complexity:

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- Time Complexity:
- Space Complexity:

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
EOF

echo "Created LeetCode problem structure at $DATE_FOLDER/$PROBLEM_FOLDER"
echo "Created Java solution at $DATE_FOLDER/$PROBLEM_FOLDER/java/solution.java"
echo "Created Jupyter notebook solution at $DATE_FOLDER/$PROBLEM_FOLDER/python/solution.ipynb"
