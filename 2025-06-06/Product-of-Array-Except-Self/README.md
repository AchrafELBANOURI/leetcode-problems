# Daily LeetCode Problem - June 06, 2025

## Problem

[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) - Medium

## Problem Statement

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in `O(n)` time and uses only constant extra space (excluding the output array).

### Examples

**Example 1:**

```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

**Example 2:**

```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

### Constraints

- 2 <= nums.length <= 10^5
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses two passes to calculate the product of the array except for the current element:

1. Initialize a `result` array with all elements set to 1.
2. Perform a forward pass:
   - Use a variable `prec` to store the cumulative product of elements before the current index.
   - Update `result[i]` with `prec` and multiply `prec` by `nums[i]`.
3. Perform a backward pass:
   - Use a variable `postc` to store the cumulative product of elements after the current index.
   - Multiply `result[i]` by `postc` and update `postc` with `nums[i]`.
4. Return the `result` array.

This approach ensures that the space complexity remains constant, excluding the output array.

#### Complexity Analysis

- Time Complexity: O(n) - two passes through the array.
- Space Complexity: O(1) - constant space used for variables.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution uses two passes to calculate the product of the array except for the current element:

1. Initialize a `result` list with all elements set to 1.
2. Perform a forward pass:
   - Use a variable `prec` to store the cumulative product of elements before the current index.
   - Update `result[ind]` with `prec` and multiply `prec` by `nums[ind]`.
3. Perform a backward pass:
   - Use a variable `postc` to store the cumulative product of elements after the current index.
   - Multiply `result[ind]` by `postc` and update `postc` with `nums[ind]`.
4. Return the `result` list.

This approach ensures that the space complexity remains constant, excluding the output list.

#### Complexity Analysis

- Time Complexity: O(n) - two passes through the array.
- Space Complexity: O(1) - constant space used for variables.

## Notes/Explanation

- Both solutions leverage the idea of prefix and suffix products to efficiently calculate the result without using division.
