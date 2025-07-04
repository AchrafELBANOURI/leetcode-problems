# Daily LeetCode Problem - October 04, 2023

## Problem

[2273. Score of a String](https://leetcode.com/problems/score-of-a-string/) - Medium

## Problem Statement

You are given a string `s` consisting of lowercase English letters. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

Return the score of the given string `s`.

### Examples

**Example 1:**
```
Input: s = "hello"
Output: 13
Explanation:
The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
```

**Example 2:**
```
Input: s = "zaz"
Output: 50
Explanation:
The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
```

### Constraints

- `2 <= s.length <= 100`
- `s` consists only of lowercase English letters.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution iterates through the string `s` and calculates the score by summing the absolute differences between the ASCII values of adjacent characters.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the length of the string. Each pair of adjacent characters is processed once.
- **Space Complexity**: O(1), as no additional space is used.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution defines a function `scoreOfString` that calculates the score by iterating through the string and summing the absolute differences between the ASCII values of adjacent characters.

#### Complexity Analysis

- **Time Complexity**: O(n), where n is the length of the string. Each pair of adjacent characters is processed once.
- **Space Complexity**: O(1), as no additional space is used.