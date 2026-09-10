# Daily LeetCode Problem - September 10, 2026

## Problem

[539. Minimum Time Difference](https://leetcode.com/problems/minimum-time-difference/)

## Problem Statement

Given a list of 24-hour clock time points in `"HH:MM"` format, return _the minimum minutes difference between any two time-points in the list_.

### Examples

**Example 1:**

- **Input:** `timePoints = ["23:59","00:00"]`
- **Output:** `1`

**Example 2:**

- **Input:** `timePoints = ["00:00","23:59","00:00"]`
- **Output:** `0`

### Constraints

- `2 <= timePoints.length <= 2 * 10^4`
- `timePoints[i]` is in the format `"HH:MM"`.

---

## Key Logic & Mathematical Formulas

### 1. Fast String Parsing to Minutes

Instead of string split operations, convert `"HH:MM"` directly into total minutes from `00:00` using character ASCII arithmetic:

$$\text{minute} = (tp[0] - \text{'0'}) \times 600 + (tp[1] - \text{'0'}) \times 60 + (tp[3] - \text{'0'}) \times 10 + (tp[4] - \text{'0'})$$

```python
# Core minute conversion logic
minute = (
    (ord(tp[0]) - ord("0")) * 600
    + (ord(tp[1]) - ord("0")) * 60
    + (ord(tp[3]) - ord("0")) * 10
    + (ord(tp[4]) - ord("0"))
)
```

### 2. Pigeonhole Principle Optimization

There are only $24 \times 60 = 1440$ unique minutes in a day.
If $N > 1440$, by the Pigeonhole Principle at least two time points must be identical:

$$\text{If } \vert{}timePoints\vert{} > 1440 \implies \min(\Delta t) = 0$$

### 3. Handling Midnight Circular Difference

Because 24-hour time wraps around at midnight, the difference between the latest time point ($\text{prevMinute}$) and the earliest time point ($\text{firstMinute}$) spans across midnight:

$$\text{cornerDiff} = (\text{firstMinute} + 1440) - \text{prevMinute}$$

$$\text{minDiff} = \min\left(\min_{i} (i - \text{prevMinute}), \, \text{cornerDiff}\right)$$

---

## Algorithmic Steps

1. **Pigeonhole Check:** Return `0` immediately if `len(timePoints) > 1440`.
2. **Bucket Tracking:** Allocate a boolean array of size `1440`. Parse each time point directly into minute indices. If an index is already marked `True`, return `0` (duplicate found).
3. **Linear Sweep:** Scan the boolean array from `0` to `1439` once to measure differences between adjacent `True` indices (`i - prevMinute`).
4. **Boundary Resolution:** Evaluate `cornerDiff` to check the circular time gap across midnight, returning the global minimum.

---

## Complexity Analysis

- **Time Complexity:** $O(N)$ overall (bounded constant time $O(1440) \approx O(1)$).
- **Space Complexity:** $O(1)$ auxiliary space for the fixed $1440$-element boolean lookup array.
