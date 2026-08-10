# Daily LeetCode Problem - August 10, 2026

## Problem

[792. Number of Matching Subsequences](https://leetcode.com/problems/number-of-matching-subsequences/)

## Problem Statement

Given a string `s` and an array of strings `words`, return _the number of `words[i]` that is a subsequence of `s`_.

A **subsequence** of a string is a new string generated from the original string by deleting some (can be none) of the characters without changing the relative order of the remaining characters.

- For example, `"ace"` is a subsequence of `"abcde"`.

### Example 1

```text
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
```

### Example 2

```text
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbgdc","ahm"]
Output: 2
```

## Solutions

### Java Solution

Located in [`java/numberOfMatchingSubsequences/Solution.java`](java/numberOfMatchingSubsequences/Solution.java)

#### Approach

We use a **Frequency Map + Linear Search (`indexOf`)** approach.

To optimize against redundant computations for identical words in `words`, we first count word frequencies using a `HashMap`. For each unique word, we check if it forms a valid subsequence by incrementally searching for each character in `s` using `s.indexOf(c, idx + 1)`. If valid, we add its frequency count to the result total.

```java
package numberOfMatchingSubsequences;

import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // Count Word Frequencies
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Compute total matching
        int result = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (isValidSequence(s, word)) {
                result += count;
            }
        }

        return result;
    }

    private boolean isValidSequence(String s, String word) {
        int idx = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            idx = s.indexOf(c, idx + 1);
            if (idx == -1) return false;
        }
        return true;
    }
}
```

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(U \cdot M \cdot |S|)$ — where $U$ is the number of unique words, $M$ is the average word length, and $|S|$ is the length of string `s`.
- **Space Complexity:** $\mathcal{O}(U)$ — to store unique word frequencies in the HashMap.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

We implemented three variations to analyze performance trade-offs:

1. **`numMatchingSubseq_Deque` (Bucket Processing via Deque):** Groups words into queues by their current waiting character using `defaultdict(deque)`. Advances pointers in a single pass over `s`.
2. **`numMatchingSubseq_List` (Bucket Processing via List Replacement):** Uses lists instead of deques by clearing `charMap[c]` each step to avoid queue removal overhead.
3. **`numMatchingSubseq` (Counter + `find` Search):** Uses Python's `Counter` to collapse duplicate words, then uses string searching (`s.find(char, idx + 1)`) to validate unique strings.

```python
from typing import List, Any
from collections import defaultdict, deque, Counter

class Solution:
    # Option 1: Bucket Processing with Deque
    def numMatchingSubseq_Deque(self, s: str, words: List[str]) -> int:
        charMap = defaultdict(deque)
        for word in words:
            charMap[word[0]].append(word)

        count = 0
        for c in s:
            wordsWaiting = charMap[c]
            for _ in range(len(wordsWaiting)):
                w = wordsWaiting.popleft()
                newW = w[1:]
                if not newW:
                    count += 1
                else:
                    charMap[newW[0]].append(newW)

        return count

    # Option 2: Bucket Processing with List Snapshot
    def numMatchingSubseq_List(self, s: str, words: List[str]) -> int:
        charMap = defaultdict(list)
        for word in words:
            charMap[word[0]].append(word)

        count = 0
        for c in s:
            waitingWords = charMap[c]
            charMap[c] = []
            for w in waitingWords:
                newW = w[1:]
                if not newW:
                    count += 1
                else:
                    charMap[newW[0]].append(newW)

        return count

    # Option 3: Counter + String Search
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        def computeIfValid(st):
            idx = -1
            for char in st:
                idx = s.find(char, idx + 1)
                if idx == -1:
                    return 0
            return 1

        word_counts = Counter(words)
        return sum(
            computeIfValid(word) * count for word, count in word_counts.items()
        )
```

#### Complexity Analysis

- **Time Complexity:**
  - Bucket approaches (`Deque` / `List`): $\mathcal{O}(|S| + \sum |W_i|)$ — optimal single-pass over `s`.
  - Frequency search approach (`Counter`): $\mathcal{O}(U \cdot M \cdot |S|)$ — dependent on the number of unique words $U$.
- **Space Complexity:** $\mathcal{O}(\sum |W_i|)$ — to maintain buckets and word states.

## Notes/Explanation

- **Single Pass vs Repeated Search:**  
  The optimal way to solve this problem for arbitrary inputs is waiting-buckets ($\mathcal{O}(|S| + \sum |W_i|)$). It processes all words concurrently as `s` streams past, avoiding repeatedly rescanning `s`.
- **Frequency Optimization:**  
  In test suites with high duplicate word rates (e.g., LeetCode test cases), pairing string search (`indexOf` / `find`) with frequency counting (`HashMap` / `Counter`) provides a huge practical speedup by executing the search loop only once per distinct word.
