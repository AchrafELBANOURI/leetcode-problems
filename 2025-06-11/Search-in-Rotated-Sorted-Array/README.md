# Daily LeetCode Problem - June 11, 2025

## Problem

[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) - Medium

## Problem Statement

There is an integer array `nums` sorted in ascending order (with distinct values).

Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index 3 and become `[4,5,6,7,0,1,2]`.

Given the array `nums` after the possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.

You must write an algorithm with `O(log n)` runtime complexity.

### Examples

**Example 1:**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

**Example 3:**

```
Input: nums = [1], target = 0
Output: -1
```

### Constraints

- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- All values of `nums` are unique.
- `nums` is guaranteed to be rotated at some pivot.
- `-10^4 <= target <= 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution implements a binary search algorithm specifically adapted for rotated sorted arrays:

1. Initialize left (`l`) and right (`r`) pointers to the start and end of the array.
2. Within each iteration of the binary search:
   - Calculate the middle index (`m`).
   - If the middle element equals the target, return the index.
   - Determine which half of the array is sorted:
     - If the left half is sorted (`nums[m] >= nums[l]`):
       - Check if the target is in the left sorted half (`nums[l] <= target && target < nums[m]`).
       - If so, search in the left half; otherwise, search in the right half.
     - If the right half is sorted:
       - Check if the target is in the right sorted half (`nums[m] < target && target <= nums[r]`).
       - If so, search in the right half; otherwise, search in the left half.
3. If the target is not found, return -1.

#### Complexity Analysis

- Time Complexity: O(log n) - Binary search algorithm.
- Space Complexity: O(1) - No additional space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution follows a similar binary search strategy with these steps:

1. Handle edge cases:
   - If the array is empty, return -1.
   - If the array has only one element, return 0 if it equals the target, otherwise -1.
2. Initialize left and right pointers.
3. Within each binary search iteration:
   - Calculate the middle index.
   - If the middle element equals the target, return the index.
   - Determine which half of the array is sorted:
     - If the left half is sorted (`nums[left] <= nums[mid]`):
       - Check if the target is in the left sorted range.
       - Adjust the search space accordingly.
     - If the right half is sorted:
       - Check if the target is in the right sorted range.
       - Adjust the search space accordingly.
4. If the target is not found, return -1.

#### Complexity Analysis

- Time Complexity: O(log n) - Binary search algorithm.
- Space Complexity: O(1) - No additional space is used.

## Notes/Explanation

The key insight for this problem is understanding that in a rotated sorted array, at least one half (left or right of the middle) must be sorted. This property allows us to determine which half to search by checking:

1. Which half is sorted (comparing the middle element with the leftmost or rightmost elements).
2. Whether the target is within the range of the sorted half.

This approach maintains the O(log n) time complexity requirement while handling the challenges posed by the rotation of the array. Both the Java and Python solutions use a modified binary search that adapts to the rotation by first identifying the sorted section, then determining if the target lies within that section.
