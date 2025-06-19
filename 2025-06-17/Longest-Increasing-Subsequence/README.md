# Daily LeetCode Problem - June 17, 2025

## Problem

[300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) - Medium

## Problem Statement

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.

### Examples

**Example 1:**

```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

**Example 2:**

```
Input: nums = [0,1,0,3,2,3]
Output: 4
```

**Example 3:**

```
Input: nums = [7,7,7,7,7,7,7]
Output: 1
```

### Constraints

- `1 <= nums.length <= 2500`
- `-10^4 <= nums[i] <= 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a dynamic programming approach. An array `LIS` is initialized with a size equal to the length of the input array `nums` and filled with 1, representing the minimum length of the subsequence ending at each index. The algorithm iterates through the array in reverse order, updating the `LIS` values based on the elements that follow each index. The maximum value in the `LIS` array is returned as the result.

#### Complexity Analysis

- **Time Complexity**: O(n^2) - For each element in the array, we iterate through all subsequent elements to find the longest increasing subsequence.
- **Space Complexity**: O(n) - We use a DP array of size `n` to store the length of the longest increasing subsequence ending at each index.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses a dynamic programming approach. A list `LIS` is initialized with a size equal to the length of the input list `nums` and filled with 1, representing the minimum length of the subsequence ending at each index. The algorithm iterates through the list in reverse order, updating the `LIS` values based on the elements that follow each index. The maximum value in the `LIS` list is returned as the result.

#### Complexity Analysis

- **Time Complexity**: O(n^2) - For each element in the array, we iterate through all subsequent elements to find the longest increasing subsequence.
- **Space Complexity**: O(n) - We use a DP array of size `n` to store the length of the longest increasing subsequence ending at each index.

## Notes/Explanation

Another approach to solving the Longest Increasing Subsequence problem is using **Patience Sorting**. This method involves maintaining a list of piles where each pile represents the smallest possible ending value of an increasing subsequence of a given length. The algorithm uses binary search to efficiently place each element in the correct pile, resulting in a time complexity of O(n log n) and a space complexity of O(n).

Here is the code for the Patience Sorting approach in Python:

```python
from bisect import bisect_left

def lengthOfLIS(nums):
    piles = []
    for num in nums:
        pos = bisect_left(piles, num)
        if pos == len(piles):
            piles.append(num)
        else:
            piles[pos] = num
    return len(piles)
```

### Explanation of `bisect_left`

The `bisect_left` function is part of Python's `bisect` module. It performs a binary search on a sorted list and returns the index where a given element should be inserted to maintain the sorted order. If the element already exists in the list, it returns the index of the first occurrence of the element. This makes it useful for efficiently finding the position to update or extend the piles in the Patience Sorting algorithm.
