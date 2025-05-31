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
EOF

# Create the Python solution file
cat > "$DATE_FOLDER/$PROBLEM_FOLDER/python/solution.py" << 'EOF'
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

Located in [`python/solution.py`](python/solution.py)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- Time Complexity:
- Space Complexity:

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
EOF

echo "Created LeetCode problem structure at $DATE_FOLDER/$PROBLEM_FOLDER"
