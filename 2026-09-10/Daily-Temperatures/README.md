# Daily LeetCode Problem - September 10, 2026

## Problem

[739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

## Problem Statement

Given an array of integers `temperatures` represents the daily temperatures, return _an array_ `answer` _such that_ `answer[i]` _is the number of days you have to wait after the_ $i^{\text{th}}$ _day to get a warmer temperature_. If there is no future day for which this is possible, keep `answer[i] == 0` instead.

## Solutions

### Java Solution

Located in [`java/dailyTemperatures/Solution.java`](java/dailyTemperatures/Solution.java)

#### Approach

Used a monotonic decreasing stack implemented with a fixed-size primitive integer array to process temperatures in reverse order (right-to-left).

1. **Reverse Traversal & Monotonic Stack:**
   - Pre-allocated `stackIndices` array to store indices of future days and `answer` array initialized to zeros.
   - Iterated backwards from `temperatures.length - 1` down to `0`.
2. **Stack Maintenance:**
   - While the stack is non-empty (`top > 0`) and the temperature at the index stored at the top of the stack is less than or equal to `dayTemp`, decremented `top` to pop colder/equal days.
   - If the stack is not empty after popping, the index at `stackIndices[top - 1]` represents the next warmer day. Recorded `answer[i] = stackIndices[top - 1] - i`.
3. **Push Current Day:** Stored the current day's index at `stackIndices[top]` and incremented `top`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the length of `temperatures`. Each index is pushed and popped from the stack at most once.
- **Space Complexity:** $O(N)$ for the pre-allocated `stackIndices` array and result buffer `answer`.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrored the right-to-left monotonic stack approach using pre-allocated lists and an explicit pointer.

1. **Array Index Stack:**
   - Initialized `stack_indices = [0] * n` and `answer = [0] * n` with `top = 0`.
   - Iterated in reverse using `range(n - 1, -1, -1)`.
2. **Popping Colder Days:**
   - Maintained a monotonically decreasing order of temperatures on the stack by popping indices where `temperatures[stack_indices[top - 1]] <= day_temp`.
   - Calculated the distance to the next warmer day using index arithmetic `stack_indices[top - 1] - i`.
3. **Execution Harness:** Processed automated test cases in `main()` and validated expected outputs with `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ linear time.
- **Space Complexity:** $O(N)$ auxiliary space for the fixed index stack array.

---

## Notes/Explanation

- **Why Right-to-Left?** Iterating backwards guarantees that when processing day $i$, all potential future days $> i$ are already stored on the stack. The top of the stack always points directly to the nearest future day with a higher temperature.
- **Monotonic Property:** Elements in the stack are kept strictly decreasing in temperature from bottom to top. Any day colder than or equal to the current day can never be the "next warmer day" for any preceding day, so popping it is optimal and safe.
