# Daily LeetCode Problem - June 07, 2025

## Problem

[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) - Medium

## Problem Statement

Given an integer array `nums`, find the subarray with the largest sum, and return its sum.

### Examples

**Example 1:**

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum = 6.
```

**Example 2:**

```
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum = 1.
```

**Example 3:**

```
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum = 23.
```

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses Kadane's Algorithm to find the maximum subarray sum:

1. Initialize two variables: `currentSum` to store the sum of the current subarray and `globalSum` to store the maximum sum.
2. Iterate through the array:
   - Update `currentSum` to the maximum of `currentSum + nums[i]` or `nums[i]`.
   - Update `globalSum` to the maximum of `globalSum` or `currentSum`.
3. Return `globalSum` after the loop.

This approach ensures that the time complexity is linear.

#### Complexity Analysis

- Time Complexity: O(n) - we traverse the array once.
- Space Complexity: O(1) - no additional space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses Kadane's Algorithm to find the maximum subarray sum:

1. Initialize two variables: `currSum` to store the sum of the current subarray and `globalSum` to store the maximum sum.
2. Iterate through the array:
   - Update `currSum` to the maximum of `currSum + item` or `item`.
   - Update `globalSum` to the maximum of `globalSum` or `currSum`.
3. Return `globalSum` after the loop.

This approach ensures that the time complexity is linear.

#### Complexity Analysis

- Time Complexity: O(n) - we traverse the array once.
- Space Complexity: O(1) - no additional space is used.

## Notes/Explanation

- Kadane's Algorithm is a dynamic programming approach that efficiently finds the maximum subarray sum in linear time.

- Dynamic Programming breaks down complex problems into simpler subproblems:
    - In this case, we're solving the "maximum subarray ending at position i" for each position
    - Each step builds on previous results, storing only what's needed (the current max)
    - This "optimal substructure" property is key to dynamic programming solutions
- The algorithm maintains two variables: current sum (local maximum) and global maximum
- At each step, we decide whether to extend the previous subarray or start a new one
