# Daily LeetCode Problem - $(date +%B\ %d,\ %Y)

## Problem

[55. Jump Game](https://leetcode.com/problems/jump-game/) - Medium

## Problem Statement

You are given an integer array `nums`. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

### Examples

**Example 1:**
```
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**
```
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
```

### Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^5`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a greedy approach to solve the problem. Starting from the second-to-last index, it iterates backward through the array, checking if the current index can reach the `goal` index. If it can, the `goal` is updated to the current index. The process continues until the first index is reached, and the function returns whether the `goal` is equal to 0.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the length of the array. Each element is processed once.
- **Space Complexity**: O(1), as no additional space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also employs a greedy approach. It uses a similar logic to the Java solution, iterating backward through the array and updating the `goal` index whenever the current index can reach it. The function returns whether the `goal` is equal to 0 after processing all elements.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the length of the array. Each element is processed once.
- **Space Complexity**: O(1), as no additional space is used.