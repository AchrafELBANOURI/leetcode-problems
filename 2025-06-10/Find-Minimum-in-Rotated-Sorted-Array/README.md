# Daily LeetCode Problem - June 10, 2025

## Problem

[153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) - Medium

## Problem Statement

Suppose an array of length `n` sorted in ascending order is rotated between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:

- `[4,5,6,7,0,1,2]` if it was rotated `4` times.
- `[0,1,2,4,5,6,7]` if it was rotated `7` times.

Notice that rotating an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of unique elements, return the minimum element of this array.

You must write an algorithm that runs in `O(log n)` time.

### Examples

**Example 1:**

```
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
```

**Example 3:**

```
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
```

### Constraints

- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- All the integers of `nums` are unique.
- `nums` is sorted and rotated between `1` and `n` times.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach
The Java solution uses a binary search algorithm to find the minimum element in the rotated sorted array:

1. Handle edge cases:
   - If the array has only one element, return it.
   - If the array is not rotated (i.e., the last element is greater than the first element), return the first element.

2. Use binary search with two pointers (leftMost and rightMost):
   - Calculate the middle index.
   - Check if the middle element is greater than the element after it. If so, the element after the middle is the minimum.
   - Check if the middle element is less than the element before it. If so, the middle element is the minimum.
   - If the middle element is greater than the first element, search in the right half.
   - Otherwise, search in the left half.

3. If no minimum is found in the loop, return the element at the leftMost pointer.

#### Complexity Analysis

- Time Complexity: O(log n) - Binary search algorithm.
- Space Complexity: O(1) - No additional space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach
The Python solution follows the same binary search strategy as the Java solution:

1. Handle edge cases:
   - If the array has only one element, return it.
   - If the array is not rotated, return the first element.

2. Use binary search with two pointers (leftMost and rightMost):
   - Calculate the middle index.
   - Check if the middle element is greater than the element after it. If so, return the element after the middle.
   - Check if the middle element is less than the element before it. If so, return the middle element.
   - If the middle element is greater than the first element, search in the right half.
   - Otherwise, search in the left half.

3. If no minimum is found in the loop, return the element at the leftMost pointer.

#### Complexity Analysis

- Time Complexity: O(log n) - Binary search algorithm.
- Space Complexity: O(1) - No additional space is used.

## Notes/Explanation
The key insight in this problem is that in a rotated sorted array, the minimum element is the only one that is smaller than both its neighbors (with appropriate checks for array boundaries). This property allows us to use binary search to efficiently find the minimum element.

When comparing the middle element with its neighbors:
- If the middle element is greater than the next element, the next element is the minimum.
- If the middle element is less than the previous element, the middle element is the minimum.

Additionally, we can determine which half of the array to search by comparing the middle element with the first element:
- If the middle element is greater than the first element, the minimum must be in the right half.
- Otherwise, the minimum must be in the left half.

Both the Java and Python solutions achieve the optimal O(log n) time complexity required by the problem statement.
