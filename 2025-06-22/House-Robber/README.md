# Daily LeetCode Problem - June 22, 2025

## Problem

[198. House Robber](https://leetcode.com/problems/house-robber/) - Medium

## Problem Statement

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

### Examples

**Example 1:**
```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
```

**Example 2:**
```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9), and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
```

### Constraints
- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 400`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

This solution uses dynamic programming with constant space. It iterates from the end of the array to the beginning, at each step deciding whether to rob the current house (and add its value to the best solution two houses ahead) or skip it (and take the best solution from the next house). Two variables are used to keep track of the maximum money that can be robbed from the next house and the house after that, updating them as the loop progresses. This avoids the need for an extra array and achieves O(1) space complexity.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the number of houses. Each house is visited once.
- **Space Complexity**: O(1), as the solution uses constant extra space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses dynamic programming with constant space. It iterates backwards through the list of houses, at each step choosing the maximum between robbing the current house (and adding its value to the best solution two houses ahead) or skipping it (and taking the best from the next house). Two variables are maintained to store the results for the next and next-plus-one houses, which are updated in each iteration. This approach is efficient and avoids extra memory usage.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the number of houses. Each house is visited once.
- **Space Complexity**: O(1), as the solution uses constant extra space.