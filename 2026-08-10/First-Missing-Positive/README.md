# Daily LeetCode Problem - August 10, 2026

## Problem

[LeetCode 41 - First Missing Positive](https://leetcode.com/problems/first-missing-positive/)

## Problem Statement

Given an unsorted integer array `nums`, return the smallest missing positive integer.

You must implement an algorithm that runs in $O(n)$ time and uses $O(1)$ auxiliary space.

## Solutions

### Java Solution

Located in [`java/firstMissingPositive/Solution.java`](java/firstMissingPositive/Solution.java)

#### Approach

The algorithm uses the input array itself as a hash table to track present positive numbers while keeping space complexity at $O(1)$:

1. **Clean Out-of-Bound Values:** Iterate through `nums` and replace all non-positive integers ($\le 0$) with $n + 1$ (where $n$ is the array length), as the answer must fall in the range $[1, n + 1]$.
2. **In-Place Index Marking:** Iterate through the array to process values. For each number $x = |\text{nums}[i]|$, if $x \le n$, negate the value at index $x - 1$ ($\text{nums}[x - 1]$) to signal that $x$ exists in the array.
3. **Find First Unmarked Index:** Iterate from index $0$ to $n - 1$. The first index containing a non-negative value corresponds to the smallest missing positive number $i + 1$. If all indices are negative, return $n + 1$.

#### Complexity Analysis

- **Time Complexity:** $O(n)$ — Requires three linear passes over the array of size $n$.
- **Space Complexity:** $O(1)$ — Performs all index modifications in-place without auxiliary data structures.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python implementation mirrors the 3-pass sign-negation technique:

1. Filter out non-positive elements by replacing values $\le 0$ with $n + 1$.
2. For each element $x$ in range $[1, n]$, mark its presence by turning $\text{nums}[x - 1]$ negative using `abs()`.
3. Scan the array to locate the first positive value at index $i - 1$, returning $i$. If all values up to $n$ are marked, return $n + 1$.

#### Complexity Analysis

- **Time Complexity:** $O(n)$ — Three sequential $O(n)$ iterations.
- **Space Complexity:** $O(1)$ — In-place array transformation using constant extra memory.

---

## Notes/Explanation

- **Why $n + 1$ works as a placeholder:** By Pigeonhole Principle, the smallest missing positive integer must be within $[1, n + 1]$. Replacing non-positive numbers with $n + 1$ prevents negative numbers from interfering with index-based sign marking.
- **Preserving Original Values with `abs()`:** Since elements are negated during pass 2, taking `abs(nums[i - 1])` ensures we always read the original magnitude of the element when indexing into the array.
