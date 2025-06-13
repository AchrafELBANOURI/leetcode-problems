# Daily LeetCode Problem - June 13, 2025

## Problem

[338. Counting Bits](https://leetcode.com/problems/counting-bits/) - Easy

## Problem Statement

Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i` (`0 <= i <= n`), `ans[i]` is the number of `1`'s in the binary representation of `i`.

### Examples

**Example 1:**

```
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0 (no 1's)
1 --> 1 (1 has 1 '1' bit)
2 --> 10 (2 has 1 '1' bit)
```

**Example 2:**

```
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0 (no 1's)
1 --> 1 (1 has 1 '1' bit)
2 --> 10 (2 has 1 '1' bit)
3 --> 11 (3 has 2 '1' bits)
4 --> 100 (4 has 1 '1' bit)
5 --> 101 (5 has 2 '1' bits)
```

### Constraints

- `0 <= n <= 10^5`

### Follow Up

- Can you solve it in linear time O(n) and using only O(1) extra space?

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a bit manipulation technique based on the following pattern:

```java
for(int i = 1; i < n + 1; i++) 
    output[i] = output[i & (i-1)] + 1;
```

This approach is based on Brian Kernighan's algorithm and relies on the insight that:
- `i & (i-1)` removes the rightmost set bit (1) from the binary representation of `i`
- Therefore, the number of 1's in `i` equals the number of 1's in `i & (i-1)` plus 1

For example:
- For i = 3 (binary 11), i-1 = 2 (binary 10), i & (i-1) = 2 (binary 10)
- output[3] = output[2] + 1 = 1 + 1 = 2

This creates a dynamic programming solution where we reuse previously computed results.

#### Complexity Analysis

- Time Complexity: O(n) - We need to compute the bits for each number from 0 to n.
- Space Complexity: O(n) - To store the result array of length n+1.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution implements the same bit manipulation technique as the Java solution:

```python
def countBits(n: int) -> list[int]:
    output = [0]*(n+1)
    for i in range(1,n+1):
        output[i] = output[i & (i-1)] + 1
    return output
```

This implementation:
1. Initializes an array with all zeros
2. For each number from 1 to n:
   - Computes i & (i-1) to remove the rightmost set bit
   - Sets output[i] to output[i & (i-1)] + 1
   
The solution also includes a commented alternative approach using powers of 2:
```python
# output[i] = output[i-(2**math.floor(math.log2(i)))]+1
```
This approach uses the insight that counting bits for a number can leverage previously calculated counts for numbers that differ by the largest power of 2 less than i.

#### Complexity Analysis

- Time Complexity: O(n) - We need to compute the bits for each number from 0 to n.
- Space Complexity: O(n) - To store the result array of length n+1.

## Notes/Explanation

### Dynamic Programming Approaches for Counting Bits

This problem lends itself to multiple dynamic programming approaches, all with O(n) time complexity:

1. **Brian Kernighan's Algorithm** (Implemented in both solutions)
   - The key insight is that `i & (i-1)` removes the rightmost set bit from `i`
   - We can reuse previously computed counts: bits in `i` = bits in `i & (i-1)` + 1
   - This provides an elegant O(n) solution

2. **Least Significant Bit (LSB) Pattern**
   - For any number `i`, count of bits = count of bits in `i >> 1` + `i & 1`
   - Implementation: `output[i] = output[i >> 1] + (i & 1)`
   - This leverages the fact that right-shifting preserves all bits except the LSB

3. **Power of Two Pattern** (Commented in the Python solution)
   - For a number `i`, find the largest power of 2 less than or equal to `i` (let's call it `p`)
   - Then bits in `i` = bits in `i - p` + 1
   - Implementation: `output[i] = output[i - (1 << log2(i))] + 1`

All these approaches achieve the optimal O(n) time complexity required by the follow-up question, though the O(n) space complexity cannot be avoided as we need to store the result array.
