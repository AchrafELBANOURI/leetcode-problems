# Daily LeetCode Problem - June 13, 2025

## Problem

[191. Number of 1-Bits](https://leetcode.com/problems/number-of-1-bits/) - Easy

## Problem Statement

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

**Note:**

- Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
- In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in **Example 3**, the input represents the signed integer `-3`.

### Examples

**Example 1:**

```
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
```

**Example 2:**

```
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
```

**Example 3:**

```
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
```

### Constraints

- The input must be a binary string of length `32`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution utilizes the built-in `Integer.bitCount()` method to efficiently count the number of '1' bits in the binary representation of the integer:

```java
public int hammingWeight(int n) {
    return Integer.bitCount(n);
}
```

This method is specifically designed to count set bits in an integer and handles all the bit manipulation internally, making the solution concise and efficient.

An alternative approach (not used in the final solution but worth noting) would be to manually count the bits by:
1. Iterating through all 32 bits of the integer
2. Checking if the least significant bit is 1 using bitwise AND with 1
3. Right-shifting the bits by 1 position after each check
4. Counting the total number of 1-bits encountered

#### Complexity Analysis

- Time Complexity: O(1) - We always handle a fixed number of bits (32-bit integers).
- Space Complexity: O(1) - We use only constant extra space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution takes advantage of Python's built-in functions to create an elegant one-liner:

```python
def hammingWeight(n: int) -> int:
    return bin(n).count('1')
```

This solution works in two steps:
1. First, `bin(n)` converts the integer to its binary string representation, prefixed with '0b'
2. Then, the `count('1')` method counts all occurrences of the character '1' in that string

This approach is both concise and easy to understand, making effective use of Python's high-level functions.

#### Complexity Analysis

- Time Complexity: O(1) - We always handle a fixed number of bits (32-bit integers).
- Space Complexity: O(1) - We use only constant extra space.

## Notes/Explanation

### Different Approaches to Count Bits

There are several ways to count the number of set bits ('1's) in a binary number:

1. **Built-in Functions** (Used in both solutions)
   - Java's `Integer.bitCount()` and Python's `bin(n).count('1')` provide the most elegant solutions
   - These functions are optimized for performance and are typically the preferred approach

2. **Bit Manipulation** (Alternative approach)
   - Iterating through each bit position and checking with masks
   - Using `n & 1` to check the least significant bit, then right-shifting
   - This approach works in any language but requires more code

3. **Brian Kernighan's Algorithm** (More efficient alternative)
    - Using the trick that `n & (n-1)` removes the rightmost set bit
    - Loop until n becomes 0, counting each operation
    ```java
    int count = 0;
    while (n != 0) {
         n &= (n - 1);
         count++;
    }
    return count;
    ```
    - This approach is efficient as it only iterates as many times as there are set bits

4. **Loop and Sum Approach**
    - Iterating through all 32 bits and summing the values
    ```java
    int count = 0;
    for (int i = 0; i < 32; i++) {
         count += (n >> i) & 1;
    }
    return count;
    ```
    - This method checks each bit position and adds 1 to the count when a set bit is found

Both Java and Python solutions prioritize readability and performance by using language-specific built-in functions, making them ideal solutions for this problem.
