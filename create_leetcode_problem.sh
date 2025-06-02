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

class Solution {
    // TODO: Implement solution method here
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        // TODO: Add test case 1
        
        // Test Case 2
        System.out.println("Test Case 2:");
        // TODO: Add test case 2
        
        // Test Case 3
        System.out.println("Test Case 3:");
        // TODO: Add test case 3
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
    "def two_sum(nums : list[int], target : int) -> list[int] :\\n",
    "    # TODO: Implement solution here\\n",
    "    pass"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 1 :**  \\n",
    "> **Input:** \`nums = []\`, \`target = \`  \\n",
    "> **Output:** \`[]\`"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "source": [
    "# Test CASE 1\\n",
    "nums = []\\n",
    "target = 0\\n",
    "output = two_sum(nums, target)\\n",
    "print(output)  # Expected: []"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 2 :**  \\n",
    "> **Input:** \`nums = []\`, \`target = \`  \\n",
    "> **Output:** \`[]\`"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "source": [
    "# Test CASE 2\\n",
    "nums = []\\n",
    "target = 0\\n",
    "output = two_sum(nums, target)\\n",
    "print(output)  # Expected: []"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {},
   "source": [
    "### **CASE 3 :**  \\n",
    "> **Input:** \`nums = []\`, \`target = \`  \\n",
    "> **Output:** \`[]\`"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "source": [
    "# Test CASE 3\\n",
    "nums = []\\n",
    "target = 0\\n",
    "output = two_sum(nums, target)\\n",
    "print(output)  # Expected: []"
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
