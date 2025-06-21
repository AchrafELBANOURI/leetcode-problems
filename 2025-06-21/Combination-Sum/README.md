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

This solution uses backtracking to explore all possible combinations of candidates that sum up to the target. The candidates array is first sorted to optimize pruning. At each recursive call, the algorithm tries to include each candidate (starting from the current index, allowing repeated use) and recurses with the reduced target. If the target becomes zero, the current path is added to the result. If a candidate exceeds the remaining target, the branch is pruned. The recursion backtracks after each attempt to explore other possibilities.

#### Complexity Analysis

- **Time Complexity**: O(2^target) in the worst case, as each number can be used multiple times and the number of combinations grows exponentially with the target.
- **Space Complexity**: O(target) for the recursion stack and path storage.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses backtracking. It recursively builds combinations by adding candidates to the current path and reducing the target. If the target reaches zero, the current combination is valid and added to the result. The function backtracks after each recursive call to explore other combinations. Sorting the candidates can help with early pruning, but is not strictly necessary for correctness.

#### Complexity Analysis

- **Time Complexity**: O(2^target) in the worst case, as each number can be used multiple times and the number of combinations grows exponentially with the target.
- **Space Complexity**: O(target) for the recursion stack and path storage.

## Notes/Explanation

- The backtracking approach efficiently explores all possible combinations by pruning branches where the sum exceeds the target.
- The same candidate can be chosen multiple times, so the recursive call does not increment the index.
- Sorting the candidates helps with early stopping and can improve performance in practice.
- The number of unique combinations is guaranteed to be less than 150 for the given constraints, so this approach is efficient enough for the problem limits.
