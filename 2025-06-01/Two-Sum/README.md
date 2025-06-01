# Daily LeetCode Problem - June 01, 2025

## Problem

[1. Two Sum](https://leetcode.com/problems/two-sum/) - Easy

## Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

### Examples

**Example 1:**

```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

**Example 2:**

```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

**Example 3:**

```
Input: nums = [3,3], target = 6
Output: [0,1]
```

### Constraints

- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9
- Only one valid answer exists

### Follow-up

Can you come up with an algorithm that is less than O(n²) time complexity?

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a HashMap to efficiently find the pair of numbers:

1. Initialize a HashMap to store complements and their indices
2. Start by adding the complement of the first element (target - nums[0]) and its index (0) to the HashMap
3. For each subsequent element (starting from index 1):
   - Check if the current number exists as a key in the HashMap
   - If it does, we've found our pair (the current index and the stored complement's index)
   - If not, add the complement of the current number (target - nums[i]) and its index to the HashMap
4. Continue until we find a match

This implementation achieves a single-pass solution by storing complements rather than the actual elements, allowing us to check if the current number completes a pair with any previously seen element.

#### Complexity Analysis

- Time Complexity: O(n) - we traverse the array only once
- Space Complexity: O(n) - in the worst case, we store all elements in the HashMap

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution uses a dictionary for efficient lookups:

1. Initialize an empty dictionary to store value-index pairs
2. For each element in the array:
   - Check if the current value exists in the dictionary
   - If it does, we've found our pair (return the stored index and current index)
   - If not, store the complement (target - current value) with current index
3. Return empty list if no solution is found

This approach is elegant and concise, leveraging Python's dictionary for O(1) lookups. By storing complements instead of the actual values, we can check in a single pass if each number completes a pair with any previously seen number.

#### Complexity Analysis

- Time Complexity: O(n) - we only need to iterate through the array once
- Space Complexity: O(n) - in the worst case, we might need to store all elements in the dictionary
