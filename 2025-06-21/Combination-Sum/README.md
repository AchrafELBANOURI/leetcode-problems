# Daily LeetCode Problem - June 21, 2025

## Problem

[39. Combination Sum](https://leetcode.com/problems/combination-sum/) - Medium

## Problem Statement

Given an array of distinct integers `candidates` and a target integer `target`, return a list of all unique combinations of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order.

The same number may be chosen from `candidates` an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to `target` is less than `150` combinations for the given input.

### Examples

**Example 1:**

```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 can be used multiple times to form 7.
7 can be used once to form 7.
```

**Example 2:**

```
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```

**Example 3:**

```
Input: candidates = [2], target = 1
Output: []
```

### Constraints

- `1 <= candidates.length <= 30`
- `1 <= candidates[i] <= 200`
- All elements of `candidates` are distinct.
- `1 <= target <= 500`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(2^target) in the worst case, as each number can be used multiple times.
- **Space Complexity**: O(target) for the recursion stack.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(2^target) in the worst case, as each number can be used multiple times.
- **Space Complexity**: O(target) for the recursion stack.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
