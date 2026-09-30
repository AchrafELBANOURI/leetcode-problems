# Daily LeetCode Problem - September 30, 2026

## Problem

[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

## Problem Statement

Given two sorted integer arrays `nums1` and `nums2`, merge `nums2` into `nums1` as one sorted array.

`nums1` has a length of `m + n`, where the first `m` elements contain valid values and the remaining `n` elements are empty space represented by zeroes.

The merged array must be stored in `nums1` in place.

## Solutions

### Java Solution

Located in [`java/mergeSortedArray/Solution.java`](java/mergeSortedArray/Solution.java)

#### Approach

Use three pointers starting from the end of both valid portions of the arrays. Compare the largest remaining values and place the larger value at the end of `nums1`. This avoids overwriting values that still need to be processed.

#### Complexity Analysis

- Time Complexity: `O(m + n)`
- Space Complexity: `O(1)`

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Use the same three-pointer approach as the Java solution. Start from the end of both arrays and fill `nums1` from right to left with the larger remaining value.

#### Complexity Analysis

- Time Complexity: `O(m + n)`
- Space Complexity: `O(1)`

## Notes/Explanation

Working backward is important because `nums1` contains enough unused space at the end. Any remaining elements in `nums2` are copied into `nums1`; remaining elements in `nums1` are already in their correct positions.
