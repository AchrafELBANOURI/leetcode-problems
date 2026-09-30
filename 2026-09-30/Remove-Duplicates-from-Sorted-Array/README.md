# Daily LeetCode Problem - September 30, 2026

## Problem

[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Problem Statement

Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in place so each unique element appears only once.

Return the number of unique elements. The first `k` elements of `nums` should contain the unique values in sorted order.

## Solutions

### Java Solution

Located in [`java/removeDuplicatesFromSortedArray/Solution.java`](java/removeDuplicatesFromSortedArray/Solution.java)

#### Approach

Use two pointers. The pointer `i` scans the array, while `k` tracks the position of the last unique element. When a new value is found, advance `k` and store the value at `nums[k]`.

#### Complexity Analysis

- Time Complexity: `O(n)`
- Space Complexity: `O(1)`

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Use the same two-pointer technique as the Java solution. Since the array is sorted, duplicates are adjacent. Copy each new unique value into the next available position.

#### Complexity Analysis

- Time Complexity: `O(n)`
- Space Complexity: `O(1)`

## Notes/Explanation

The returned value `k + 1` represents the number of unique elements. Only the first `k + 1` positions of the modified array are relevant.
