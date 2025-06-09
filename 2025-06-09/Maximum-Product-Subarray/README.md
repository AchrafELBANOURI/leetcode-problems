# Daily LeetCode Problem - June 09, 2025

## Problem

[152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) - Medium

## Problem Statement

Given an integer array `nums`, find the contiguous subarray within an array (containing at least one number) which has the largest product.

### Examples

**Example 1:**

```
Input: nums = [2,3,-2,4]
Output: 6
Explanation: The subarray [2,3] has the largest product = 6.
```

**Example 2:**

```
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a contiguous subarray.
```

### Constraints

- 1 <= nums.length <= 10^5
- -10 <= nums[i] <= 10

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach
The Java solution uses a single pass through the array to calculate the maximum product of a contiguous subarray. It maintains two variables, `maxSoFar` and `minSoFar`, to track the maximum and minimum products at each step. These are updated based on the current element and the previous products. The result is updated whenever a new maximum product is found.

#### Complexity Analysis
- **Time Complexity:** O(n) - The array is traversed once.
- **Space Complexity:** O(1) - No additional space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach
The Python solution follows a similar approach to the Java solution. It uses two variables, `maxProduct` and `minProduct`, to track the maximum and minimum products at each step. These are updated based on the current element and the previous products. The final result is updated whenever a new maximum product is found.

#### Complexity Analysis
- **Time Complexity:** O(n) - The array is traversed once.
- **Space Complexity:** O(1) - No additional space is used.

## Notes/Explanation
Both solutions leverage the idea of maintaining the maximum and minimum products at each step to handle negative numbers effectively. This ensures that the algorithm can find the maximum product of a contiguous subarray even when negative numbers are involved.
