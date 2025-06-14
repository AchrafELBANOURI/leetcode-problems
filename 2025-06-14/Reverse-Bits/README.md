# Daily LeetCode Problem - June 14, 2025

## Problem

[190. Reverse Bits](https://leetcode.com/problems/reverse-bits/) - Easy

## Problem Statement

Reverse bits of a given 32 bits unsigned integer.

**Note:**

- Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
- In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 below, the input represents the signed integer `-3` and the output represents the signed integer `-1073741825`.

### Examples

**Example 1:**

```
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
```

**Example 2:**

```
Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
```

### Constraints

- The input must be a binary string of length `32`

### Follow Up

- If this function is called many times, how would you optimize it?

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses bit manipulation to reverse the bits of a 32-bit unsigned integer:

```java
public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result = result << 1; // Shift result left to make room
        result = result | (n & 1); // Add the last bit of n
        n = n >>> 1; // Shift n right (unsigned)
    }
    return result;
}
```

This approach processes each bit of the input integer `n` from right to left, adding it to the result in reverse order.

#### Complexity Analysis

- **Time Complexity**: O(1) - The loop always runs 32 times, regardless of the input.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution leverages string manipulation to reverse the bits of a 32-bit unsigned integer:

```python
def reverseBits(self, n: int) -> int:
    n_rev = bin(n)[2:].zfill(32)[::-1]  # Convert to binary, pad to 32 bits, and reverse
    n = int(n_rev, base=2)  # Convert back to integer
    return n
```

This approach converts the integer to its binary representation, reverses the string, and converts it back to an integer.

#### Complexity Analysis

- **Time Complexity**: O(1) - The operations on a fixed-length (32-bit) string are constant time.
- **Space Complexity**: O(1) - Only a constant amount of extra space is used.
