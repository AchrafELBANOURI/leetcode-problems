# Daily LeetCode Problem - July 5, 2026

## Problem

[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/) - Medium

## Problem Statement

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

### Examples

**Example 1:**

```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
```

**Example 2:**

```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

### Constraints

- `1 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= starti <= endi <= 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution first sorts the intervals based on their starting values. It then uses a `mergedInterval` variable to represent the current interval being built.

The algorithm iterates through the sorted intervals starting from the second interval:

- If the current interval does **not** overlap with `mergedInterval`, the completed `mergedInterval` is added to the result list, and the current interval becomes the new `mergedInterval`.
- Otherwise, the intervals overlap, so the end of `mergedInterval` is updated to the maximum of the two end values.

After the traversal, the final `mergedInterval` is added to the result list. Sorting guarantees that all overlapping intervals appear consecutively, allowing them to be merged efficiently in a single pass.

#### Complexity Analysis

- **Time Complexity**: **O(n log n)**, where `n` is the number of intervals. Sorting dominates the runtime, while the merge step is linear.
- **Space Complexity**: **O(n)**, for storing the merged intervals (excluding the space used by the sorting algorithm).

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution first sorts the intervals based on their starting values. It then uses a `merged_interval` variable to represent the current interval being built.

The algorithm iterates through the sorted intervals starting from the second interval:

1. Sort the intervals by their starting values.
2. Initialize `merged_interval` with the first interval.
3. Traverse the remaining intervals:
   - If the current interval does **not** overlap with `merged_interval`, append `merged_interval` to the result list and make the current interval the new `merged_interval`.
   - Otherwise, merge the intervals by updating the end of `merged_interval` to the maximum of the two end values.
4. After the traversal, append the final `merged_interval` to the result list.

Sorting ensures that all overlapping intervals appear consecutively, allowing them to be merged efficiently in a single pass.

#### Complexity Analysis

- **Time Complexity**: **O(n log n)**, due to sorting the intervals.
- **Space Complexity**: **O(n)**, for the output list of merged intervals.
