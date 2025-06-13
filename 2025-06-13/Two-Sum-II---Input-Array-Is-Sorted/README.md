# Daily LeetCode Problem - June 13, 2025

## Problem

[167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) - Medium

## Problem Statement

Given a **1-indexed** array of integers `numbers` that is already sorted in **non-decreasing order**, find two numbers such that they add up to a specific `target` number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 <= numbers.length`.

Return the indices of the two numbers, `index1` and `index2`, **added by one** as an integer array `[index1, index2]` of length 2.

The tests are generated such that there is **exactly one solution**. You **may not** use the same element twice.

Your solution must use only constant extra space.

### Examples

**Example 1:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
```

**Example 2:**

```
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore, index1 = 1, index2 = 3. We return [1, 3].
```

**Example 3:**

```
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore, index1 = 1, index2 = 2. We return [1, 2].
```

### Constraints

- `2 <= numbers.length <= 3 * 10^4`
- `-1000 <= numbers[i] <= 1000`
- `numbers` is sorted in **non-decreasing order**.
- `-1000 <= target <= 1000`
- The tests are generated such that there is **exactly one solution**.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a two-pointer approach to find the two numbers that sum to the target:

1. Initialize two pointers: left (`l`) at the beginning of the array and right (`r`) at the end.
2. In a loop, calculate the sum of the elements at these two pointers.
3. If the sum equals the target, return the indices (adding 1 to convert to 1-indexed).
4. If the sum is less than the target, increment the left pointer to increase the sum.
5. If the sum is greater than the target, decrement the right pointer to decrease the sum.
6. Continue until a match is found or the pointers cross.

This approach takes advantage of the array being sorted in non-decreasing order.

#### Complexity Analysis

- Time Complexity: O(n) - We traverse the array once.
- Space Complexity: O(1) - We use only constant extra space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution follows the same two-pointer technique as the Java solution:

1. Initialize left (`l`) at index 0 and right (`r`) at the last index of the array.
2. In a while loop, compare the sum of elements at these pointers with the target:
   - If the sum equals the target, return the indices (adding 1 to make them 1-indexed).
   - If the sum is less than the target, move the left pointer rightward to increase the sum.
   - If the sum is greater than the target, move the right pointer leftward to decrease the sum.
3. If no solution is found (which should not happen per the problem constraints), return an empty array.

#### Complexity Analysis

- Time Complexity: O(n) - We traverse the array once.
- Space Complexity: O(1) - We use only constant extra space.

## Notes/Explanation

The two-pointer technique is particularly effective for this problem because the input array is already sorted. This allows us to make efficient decisions about which pointer to move based on the current sum:

1. If the sum is too small, we need a larger number, so we move the left pointer rightward.
2. If the sum is too large, we need a smaller number, so we move the right pointer leftward.

This approach guarantees finding the solution in a single pass through the array, making it more efficient than alternatives like using a hash map (which would be O(n) space) or nested loops (which would be O(n²) time).
