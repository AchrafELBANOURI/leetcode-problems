# Daily LeetCode Problem - June 13, 2025

## Problem

[15. 3Sum](https://leetcode.com/problems/3sum/) - Medium

## Problem Statement

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

### Examples

**Example 1:**

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
```

**Example 2:**

```
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```

**Example 3:**

```
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
```

### Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a two-pointer technique with the following steps:

1. Sort the input array to help with duplicate handling and to enable the two-pointer technique.
2. Iterate through the array for the first element of the triplet:
   - Skip positive numbers as the first element since they can't sum to zero with two other positive numbers.
   - Skip duplicates for the first element to avoid duplicate triplets.
3. For each first element, use two pointers (left and right) to find pairs that sum with the first element to zero:
   - If the sum is greater than zero, move the right pointer leftward to decrease the sum.
   - If the sum is less than zero, move the left pointer rightward to increase the sum.
   - If the sum is zero, add the triplet to the result and move the left pointer while skipping duplicates.

#### Complexity Analysis

- Time Complexity: O(n²) - Sorting the array takes O(n log n) time, and the two-pointer technique takes O(n²) time.
- Space Complexity: O(1) - Excluding the output array, the algorithm uses constant extra space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution follows a similar approach to the Java solution:

1. Sort the array to enable efficient duplicate detection and two-pointer technique.
2. Iterate through the array for the first element of potential triplets:
   - Skip positive numbers as first elements (optimization).
   - Skip duplicates of the first element to avoid duplicate triplets.
3. Use a two-pointer approach for the remaining elements:
   - Calculate the sum of the three elements.
   - If the sum is greater than zero, decrement the right pointer.
   - If the sum is less than zero, increment the left pointer.
   - If the sum equals zero, add the triplet to the result and move the left pointer while skipping duplicates.

#### Complexity Analysis

- Time Complexity: O(n²) - Sorting the array takes O(n log n) time, and the two-pointer technique takes O(n²) time.
- Space Complexity: O(1) - Excluding the output array, the algorithm uses constant extra space.

## Notes/Explanation

The key insights for solving the 3Sum problem efficiently:

1. **Sorting the array** is crucial for both duplicate handling and enabling the two-pointer technique.

2. **Early termination** when the first element is positive (since three positive numbers can't sum to zero).

3. **Duplicate handling** at three levels:
   - Skip duplicate first elements during the main iteration.
   - Skip duplicates after finding a triplet to avoid adding the same triplet multiple times.

4. **Two-pointer technique** allows for O(n) search of complementary pairs for each first element, resulting in an overall O(n²) algorithm instead of O(n³).

Both solutions implement these concepts efficiently, though with slightly different implementations of duplicate handling.
