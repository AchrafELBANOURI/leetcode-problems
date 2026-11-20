# Daily LeetCode Problem - November 20, 2026

## Problem

[881. Boats to Save People](https://leetcode.com/problems/boats-to-save-people/) (Medium)

## Problem Statement

You are given an array `people` where `people[i]` is the weight of the `i`-th person, and an infinite number of boats where each boat can carry a maximum weight of `limit`. Each boat carries at most two people at the same time, provided the sum of their weights is at most `limit`. Return the minimum number of boats required.

- **Constraints:** `1 <= people.length <= 5 * 10^4`, `1 <= people[i] <= limit <= 3 * 10^4`

## Solutions

### Java Solution

Located in [`java/boatsToSavePeople/Solution.java`](java/boatsToSavePeople/Solution.java)

#### Approach

Utilizes a **Counting Sort + Greedy Two-Pointer** approach:

1. **Frequency Counting:** Populate a `freqWeight` array of size `limit + 1`.
2. **Two Pointers:** Track `l = 0` (lightest) and `r = limit` (heaviest).
3. **Greedy Pairing:** If `l + r > limit`, assign individual boats to weight `r`. If `l + r <= limit`, pair them greedily (`mini = min(freqWeight[l], freqWeight[r])`) and update counts.

#### Complexity Analysis

- **Time Complexity:** $O(N + M)$ ($N$ = length of `people`, $M$ = `limit`)
- **Space Complexity:** $O(M)$

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrors the Java implementation using a **Counting Sort + Greedy Two-Pointer** strategy with a `freq_weight` list of size `limit + 1`.

#### Complexity Analysis

- **Time Complexity:** $O(N + M)$
- **Space Complexity:** $O(M)$

## Notes/Explanation

- **Why Greedy Works:** Pairing the heaviest with the lightest maximizes capacity. If the lightest cannot fit with the heaviest, the heaviest must ride alone.
- **Optimization:** Leveraging `limit <= 30,000` bypasses standard $O(N \log N)$ sorting in favor of an $O(N + M)$ bucket approach.
