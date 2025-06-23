# Daily LeetCode Problem - June 23, 2025

## Problem

[91. Decode Ways](https://leetcode.com/problems/decode-ways/) - Medium

## Problem Statement

A message containing letters from `A-Z` can be encoded into numbers using the following mapping:

```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```

To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

- "AAJF" with the grouping (1 1 10 6)
- "KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string `s` containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.

### Examples

**Example 1:**
```
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
```

**Example 2:**
```
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```

**Example 3:**
```
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
```

### Constraints

- `1 <= s.length <= 100`
- `s` contains only digits and may contain leading zeros.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a dynamic programming approach with two variables (`dp1` and `dp2`) to store intermediate results. Starting from the end of the string, it iterates backward, checking if the current character is valid (not '0') and whether the two-character substring forms a valid encoding (between 10 and 26). The results are accumulated in `dp1` and `dp2` to calculate the total number of decoding ways.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the length of the string. Each character is processed once.
- **Space Complexity**: O(1), as only two variables are used for intermediate results.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also employs a dynamic programming approach. It uses a similar logic to the Java solution, iterating through the string and maintaining two variables to store the number of decoding ways for the current and previous positions. The solution handles edge cases like leading zeros and invalid two-character substrings.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the length of the string. Each character is processed once.
- **Space Complexity**: O(1), as only two variables are used for intermediate results.