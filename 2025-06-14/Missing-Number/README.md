# Daily LeetCode Problem - June 14, 2025

## Problem

[268. Missing Number](https://leetcode.com/problems/missing-number/) - Easy

## Problem Statement

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

### Examples

**Example 1:**

```
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```

**Example 2:**

```
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
```

**Example 3:**

```
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
```

### Constraints

- `n == nums.length`
- `1 <= n <= 10^4`
- `0 <= nums[i] <= n`
- All the numbers of `nums` are **unique**.

### Follow Up

Could you implement a solution using:
- Only O(1) extra space complexity and O(n) runtime complexity?
- Bit manipulation?

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a mathematical approach based on the sum formula for consecutive integers:

```java
public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum_n = (n*(n+1))/2;
    int sum_nums = 0;
    for(int i=0; i < n; i++) {
        sum_nums += nums[i];
    }
    return sum_n - sum_nums;
}
```

This approach leverages the fact that the sum of integers from 0 to n is given by the formula: `n*(n+1)/2`. The implementation:
1. Calculates the expected sum of all integers from 0 to n using this formula
2. Calculates the actual sum of the array elements
3. Returns the difference between the expected and actual sums, which is the missing number

#### Complexity Analysis

- Time Complexity: O(n) - We need to process each element in the array once.
- Space Complexity: O(1) - We only use a constant amount of extra space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution implements the same mathematical approach as the Java solution, but in a more concise way using Python's built-in `sum()` function:

```python
def missingNumber(nums: list[int]) -> int:
    n = len(nums)
    sum_n = (n*(n+1))//2
    sum_nums = sum(nums)
    return sum_n - sum_nums
```

This implementation:
1. Uses `len(nums)` to get the value of n
2. Calculates the expected sum using the formula `(n*(n+1))//2`
3. Calculates the actual sum using the built-in `sum()` function
4. Returns the difference, which is the missing number

Python's integer division operator `//` is used to ensure we get an integer result, though in this case regular division `/` would work as well since the result is always an integer.

#### Complexity Analysis

- Time Complexity: O(n) - We need to process each element in the array once.
- Space Complexity: O(1) - We only use a constant amount of extra space.

## Notes/Explanation

### Alternative Approaches

#### 1. XOR Method (Bit Manipulation)

This approach leverages the properties of XOR operations to find the missing number:

```java
// Java implementation
public int missingNumber(int[] nums) {
    int result = nums.length;
    for (int i = 0; i < nums.length; i++) {
        result ^= i ^ nums[i];
    }
    return result;
}
```

```python
# Python implementation
def missingNumber(nums: list[int]) -> int:
    result = len(nums)
    for i in range(len(nums)):
        result ^= i ^ nums[i]
    return result
```

The logic behind this approach:
- We initialize `result` with `n` (the length of the array)
- For each index `i`, we XOR `result` with both `i` and `nums[i]`
- Since XOR of a number with itself is 0, and the XOR of any number with 0 is the number itself, all numbers and their indices that are present will cancel out
- We're left with the XOR of `n` and the missing number, which equals the missing number

#### 2. Cyclic Sort

Another approach is to use cyclic sort to place each number at its correct index, then find the index that doesn't match its value:

```java
// Java implementation
public int missingNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        if (nums[i] < nums.length && nums[i] != i) {
            int correct = nums[i];
            int temp = nums[i];
            nums[i] = nums[correct];
            nums[correct] = temp;
        } else {
            i++;
        }
    }
    
    // Find the missing number
    for (i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
            return i;
        }
    }
    return nums.length;
}
```

This approach:
1. Places each number at its correct index position
2. Scans the array to find the first position where the index doesn't match the value
3. If all indices match, the missing number is `n`

#### 3. Binary Search 

For sorted arrays, a binary search approach can be used:

```java
// Java implementation
public int missingNumber(int[] nums) {
    Arrays.sort(nums);
    int left = 0, right = nums.length;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > mid) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
}
```

This approach:
1. Sorts the array
2. Performs binary search - if `nums[mid] > mid`, the missing number is in the left half; otherwise, it's in the right half

### Addressing Follow-Up Questions

#### O(1) Space and O(n) Time Solution

The mathematical sum approach already satisfies this constraint:
- Time complexity: O(n) for calculating the sum of array elements
- Space complexity: O(1) as we only use a few variables regardless of input size

#### Bit Manipulation Solution

The XOR approach described above is a bit manipulation solution with:
- Time complexity: O(n)
- Space complexity: O(1)

The XOR approach works because of these properties:
- XOR of a number with itself is 0: `a ^ a = 0`
- XOR of a number with 0 is the number itself: `a ^ 0 = a`
- XOR is commutative and associative: `a ^ b = b ^ a` and `(a ^ b) ^ c = a ^ (b ^ c)`

By XORing all numbers from 0 to n and all elements in the array, all numbers that appear in both sets cancel out, leaving only the missing number.
