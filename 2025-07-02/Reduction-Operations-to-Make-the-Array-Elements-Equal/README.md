# Daily LeetCode Problem - $(date +%B\ %d,\ %Y)

## Problem

[1887. Reduction Operations to Make the Array Elements Equal](https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/) - Medium

## Problem Statement

You are given an integer array `nums` where all the elements are distinct.

You can reduce the array by performing a reduction operation on any element of the array. In each reduction operation, the element is replaced with any smaller element in the array.

Return the number of reduction operations needed to make all the elements of the array equal.

### Examples

**Example 1:**
```
Input: nums = [5,1,3]
Output: 3
Explanation: Reduce 5 to 3 in 1 operation. Reduce 5 to 1 in 2 operations. Total operations = 3.
```

**Example 2:**
```
Input: nums = [1,1,1]
Output: 0
Explanation: All elements are already equal.
```

**Example 3:**
```
Input: nums = [1,1,2,2,3]
Output: 4
Explanation: Reduce 3 to 2 in 1 operation. Reduce 3 to 1 in 2 operations. Reduce 2 to 1 in 1 operation. Total operations = 4.
```

### Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^5`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(n log n), where n is the length of the array. Sorting the array takes O(n log n), and the reduction operations are performed in O(n).
- **Space Complexity**: O(1), as no additional space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(n log n), where n is the length of the array. Sorting the array takes O(n log n), and the reduction operations are performed in O(n).
- **Space Complexity**: O(1), as no additional space is used.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
