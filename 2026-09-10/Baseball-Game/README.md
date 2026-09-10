# Daily LeetCode Problem - September 10, 2026

## Problem

[682. Baseball Game](https://leetcode.com/problems/baseball-game/)

## Problem Statement

You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings `operations`, where `operations[i]` is the $i^{\text{th}}$ operation you must apply to the record and is one of the following:

- An integer `x`: Record a new score of `x`.
- `'+'`: Record a new score that is the sum of the previous two scores.
- `'D'`: Record a new score that is the double of the previous score.
- `'C'`: Invalidate the previous score, removing it from the record.

Return _the sum of all the scores on the record after applying all the operations_.

## Solutions

### Java Solution

Located in [`java/baseballGame/Solution.java`](java/baseballGame/Solution.java)

#### Approach

Used a fixed-size integer array as a stack simulation to maintain $O(N)$ runtime without dynamic collection overhead.

1. **Stack Pointer & Running Sum:** Maintained an array `records` equal in size to `operations.length`, a pointer `currIndex` initialized to `-1`, and a running total `resultSum`.
2. **Operation Handling:**
   - `"C"`: Subtracts `records[currIndex]` from `resultSum`, resets `records[currIndex]` to `0`, and decrements `currIndex`.
   - `"D"`: Multiples `records[currIndex]` by 2, writes to `records[++currIndex]`, and adds it to `resultSum`.
   - `"+"`: Adds `records[currIndex]` and `records[currIndex - 1]`, writes to `records[++currIndex]`, and adds it to `resultSum`.
   - `default`: Parses integer `op`, pushes it to `records[++currIndex]`, and updates `resultSum`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the number of operations. Each string is processed in $O(1)$ time.
- **Space Complexity:** $O(N)$ for the array used as stack storage.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

Simulated stack operations using Python 3.10+ pattern matching (`match/case`) with a pre-allocated fixed-size list.

1. **Fixed Array Pre-allocation:** Initialized `scores` array with zeros of length `len(operations)` and pointer `currIndex = 0`.
2. **Pattern Matching Logic:**
   - `"C"`: Decrements `currIndex` by 1 to effectively remove the top element.
   - `"D"`: Doubles `scores[currIndex - 1]`, stores it at `scores[currIndex]`, and advances `currIndex`.
   - `"+"`: Sums `scores[currIndex - 1]` and `scores[currIndex - 2]`, stores it at `scores[currIndex]`, and advances `currIndex`.
   - `_`: Converts string to `int(op)`, writes to `scores[currIndex]`, and advances `currIndex`.
3. **Summation:** Returns `sum(scores[:currIndex])` to tally all active scores.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ total execution time ($O(N)$ loop pass + $O(N)$ slice sum).
- **Space Complexity:** $O(N)$ to store array elements up to length $N$.

---

## Notes/Explanation

- **Pre-allocated Array vs Dynamic Stack:** Using a fixed array based on `operations.length` avoids the performance cost of dynamic resizing in both Java and Python while keeping space bounded by $O(N)$.
- **Running Sum Optimization:** The Java implementation keeps a running `resultSum` variable updated during stack pushes and pops, eliminating the need for a final linear pass to calculate the answer.
