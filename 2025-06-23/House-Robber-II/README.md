# Daily LeetCode Problem - June 23, 2025

## Problem

[213. House Robber II](https://leetcode.com/problems/house-robber-ii/) - Medium

## Problem Statement

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

### Examples

**Example 1:**
```
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
```

**Example 2:**
```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
```

**Example 3:**
```
Input: nums = [1,2,3]
Output: 3
```

### Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 1000`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

This solution uses dynamic programming with constant space. Since the houses are arranged in a circle, the problem is divided into two subproblems: robbing houses from the second to the last house, and robbing houses from the first to the second-to-last house. The maximum of these two results is the final answer. Two variables are used to keep track of the maximum money that can be robbed for each subproblem, avoiding the need for extra arrays.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the number of houses. Each house is visited once.
- **Space Complexity**: O(1), as the solution uses constant extra space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses dynamic programming with constant space. It calculates the maximum money that can be robbed in two scenarios: excluding the first house and excluding the last house. For each scenario, it iterates through the respective range of houses, maintaining two variables to store the results for the next and next-plus-one houses. The final result is the maximum of the two scenarios.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the number of houses. Each house is visited once.
- **Space Complexity**: O(1), as the solution uses constant extra space.