# Daily LeetCode Problem - June 17, 2025

## Problem

[300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) - Medium

## Problem Statement

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.

### Examples

**Example 1:**

```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

**Example 2:**

```
Input: nums = [0,1,0,3,2,3]
Output: 4
```

**Example 3:**

```
Input: nums = [7,7,7,7,7,7,7]
Output: 1
```

### Constraints

- `1 <= nums.length <= 2500`
- `-10^4 <= nums[i] <= 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(n^2) - For each element in the array, we iterate through all previous elements to find the longest increasing subsequence.
- **Space Complexity**: O(n) - We use a DP array of size `n` to store the length of the longest increasing subsequence ending at each index.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(n^2) - For each element in the array, we iterate through all previous elements to find the longest increasing subsequence.
- **Space Complexity**: O(n) - We use a DP array of size `n` to store the length of the longest increasing subsequence ending at each index.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
