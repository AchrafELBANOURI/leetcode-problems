# Daily LeetCode Problem - June 27, 2026

## Problem

[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) - Medium

## Problem Statement

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in `O(n)` time.

### Examples

**Example 1:**

```
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive sequence is [1, 2, 3, 4].
```

**Example 2:**

```
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

### Constraints

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

This solution uses a `HashSet` to support `O(1)` lookups. After inserting all numbers into the set, it only starts counting from numbers that do not have a predecessor in the set, which means they are the beginning of a consecutive sequence. From each start, it expands forward until the sequence ends and keeps track of the longest length found.

#### Complexity Analysis

- **Time Complexity**: `O(n)`, because each number is processed a constant number of times.
- **Space Complexity**: `O(n)`, for the set of unique numbers.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution follows the same idea as the Java version. It stores all numbers in a set, then checks only sequence starts by verifying that `n - 1` is not present. For each start, it walks forward while the next consecutive value exists and updates the best length. This keeps the solution linear and avoids unnecessary repeated work.

#### Complexity Analysis

- **Time Complexity**: `O(n)`, since each element is visited a limited number of times.
- **Space Complexity**: `O(n)`, for the set of numbers.

## Notes/Explanation

The key optimization is skipping numbers that are not sequence starts. That is what makes the `O(n)` solution possible.
