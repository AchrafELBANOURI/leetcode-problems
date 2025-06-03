# Daily LeetCode Problem - June 03, 2025

## Problem

[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) - Easy

## Problem Statement

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

### Examples

**Example 1:**

```
Input: nums = [1,2,3,1]
Output: true
```

**Example 2:**

```
Input: nums = [1,2,3,4]
Output: false
```

**Example 3:**

```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

### Constraints

- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a `HashSet` to efficiently check for duplicates:

1. Initialize an empty `HashSet` to store distinct values.
2. Iterate through the array:
   - If the current value is already in the `HashSet`, return `true` (duplicate found).
   - Otherwise, add the value to the `HashSet`.
3. If no duplicates are found after the loop, return `false`.

This approach leverages the `HashSet`'s O(1) average time complexity for insert and lookup operations.

#### Complexity Analysis

- Time Complexity: O(n) - we traverse the array once, and each `HashSet` operation is O(1) on average.
- Space Complexity: O(n) - in the worst case, we store all elements in the `HashSet`.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution uses a `set` to efficiently check for duplicates:

1. Convert the array to a `set`.
2. Compare the length of the original array with the length of the `set`.
   - If the lengths are different, return `true` (duplicates exist).
   - Otherwise, return `false`.

This approach is concise and leverages Python's built-in `set` for O(1) average time complexity for insert and lookup operations.

#### Complexity Analysis

- Time Complexity: O(n) - converting the array to a `set` requires a single traversal.
- Space Complexity: O(n) - in the worst case, we store all elements in the `set`.

## Notes/Explanation

- In Java, the `HashSet.add()` method returns `false` if the element already exists in the set. This allows for a more concise solution:

```java
public boolean containsDuplicate(int[] nums) {
    Set<Integer> distinctValues = new HashSet<>();
    for (int num : nums) {
        if (!distinctValues.add(num)) return true;
    }
    return false;
}
```

- This approach is more efficient as it combines the existence check and insertion into a single operation.
