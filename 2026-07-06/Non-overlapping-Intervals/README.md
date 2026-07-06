# Daily LeetCode Problem - July 6, 2026

## Problem

[435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) - Medium

## Problem Statement

Given an array of `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

### Examples

**Example 1:**

```text
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: Removing [1,3] leaves the rest of the intervals non-overlapping.
```

**Example 2:**

```text
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two intervals to leave only one non-overlapping interval.
```

**Example 3:**

```text
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: The intervals already do not overlap.
```

### Constraints

- `1 <= intervals.length <= 10^5`
- `intervals[i].length == 2`
- `-5 * 10^4 <= starti < endi <= 5 * 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution first sorts the intervals based on their starting values. It then keeps track of the end of the most recently selected interval using the `recentEnd` variable.

The algorithm iterates through the sorted intervals starting from the second interval:

- If the current interval starts **at or after** `recentEnd`, there is no overlap, so `recentEnd` is updated to the current interval's end.
- Otherwise, the intervals overlap. One interval must be removed, so the removal count is incremented. To maximize the chances of accommodating future intervals, `recentEnd` is updated to the smaller of the two end values, effectively keeping the interval that finishes earlier.

This greedy strategy minimizes future overlaps by always preserving the interval with the earliest ending point whenever an overlap occurs.

#### Complexity Analysis

- **Time Complexity**: **O(n log n)**, where `n` is the number of intervals. Sorting dominates the runtime, while the traversal is linear.
- **Space Complexity**: **O(1)**, excluding the space used by the sorting algorithm.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution follows the same greedy strategy:

1. Sort the intervals by their starting values.
2. Initialize `recent_end` with the end of the first interval.
3. Traverse the remaining intervals:
   - If the current interval starts **at or after** `recent_end`, there is no overlap, so update `recent_end` to the current interval's end.
   - Otherwise, the intervals overlap. Increment the removal count and update `recent_end` to the smaller of the two end values, keeping the interval that ends first.
4. Return the total number of removed intervals.

By always keeping the interval with the earliest ending point during an overlap, the algorithm leaves as much room as possible for the remaining intervals, resulting in the minimum number of removals.

#### Complexity Analysis

- **Time Complexity**: **O(n log n)**, due to sorting the intervals.
- **Space Complexity**: **O(1)**, excluding the space used by the sorting algorithm.
