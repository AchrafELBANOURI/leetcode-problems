# Daily LeetCode Problem - June 19, 2025

## Problem

[139. Word Break](https://leetcode.com/problems/word-break/) - Medium

## Problem Statement

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

### Examples

**Example 1:**

```
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: "leetcode" can be segmented as "leet code".
```

**Example 2:**

```
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
```

**Example 3:**

```
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
```

### Constraints

- `1 <= s.length <= 300`
- `1 <= wordDict.length <= 1000`
- `1 <= wordDict[i].length <= 20`
- `s` and `wordDict[i]` consist of only lowercase English letters.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- Time Complexity: O(n * m) - Where `n` is the length of `s` and `m` is the average length of words in `wordDict`. We iterate through the string and check substrings against the dictionary.
- Space Complexity: O(n) - We use a DP array of size `n` to store intermediate results.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- Time Complexity: O(n * m) - Where `n` is the length of `s` and `m` is the average length of words in `wordDict`. We iterate through the string and check substrings against the dictionary.
- Space Complexity: O(n) - We use a DP array of size `n` to store intermediate results.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
