# Daily LeetCode Problem - June 19, 2025

## Problem

[1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) - Medium

## Problem Statement

Given two strings `text1` and `text2`, return the length of their longest common subsequence. If there is no common subsequence, return `0`.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

### Examples

**Example 1:**

```
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
```

**Example 2:**

```
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
```

**Example 3:**

```
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no common subsequence.
```

### Constraints

- `1 <= text1.length, text2.length <= 1000`
- `text1` and `text2` consist of only lowercase English characters.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a dynamic programming approach. A 2D array `dp` is initialized with dimensions `(n1+1) x (n2+1)` where `n1` and `n2` are the lengths of `text1` and `text2`, respectively. The algorithm iterates through the strings in reverse order, comparing characters and updating the `dp` array based on whether the characters match or not. The value at `dp[0][0]` represents the length of the longest common subsequence.

#### Complexity Analysis

- **Time Complexity**: O(n * m) - Where `n` is the length of `text1` and `m` is the length of `text2`. We iterate through all characters of both strings to compute the LCS.
- **Space Complexity**: O(n * m) - We use a 2D DP array of size `n x m` to store intermediate results.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses a dynamic programming approach. A 2D list `dp` is initialized with dimensions `(n1+1) x (n2+1)` where `n1` and `n2` are the lengths of `text1` and `text2`, respectively. The algorithm iterates through the strings in reverse order, comparing characters and updating the `dp` list based on whether the characters match or not. The value at `dp[0][0]` represents the length of the longest common subsequence.

#### Complexity Analysis

- **Time Complexity**: O(n * m) - Where `n` is the length of `text1` and `m` is the length of `text2`. We iterate through all characters of both strings to compute the LCS.
- **Space Complexity**: O(n * m) - We use a 2D DP list of size `n x m` to store intermediate results.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
