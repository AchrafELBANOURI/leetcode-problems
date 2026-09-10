# Daily LeetCode Problem - September 10, 2026

## Problem

[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

## Problem Statement

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return _the area of the largest rectangle in the histogram_.

## Solutions

### Java Solution

Located in [`java/largestRectangleInHistogram/Solution.java`](java/largestRectangleInHistogram/Solution.java)

#### Approach

Used a monotonic increasing stack implemented with a fixed-size primitive integer array to process histogram bar indices in a single pass.

1. **Virtual Sentinel Execution:**
   - Traversed from index `0` up to `n` (inclusive).
   - Treated the virtual index `i == n` as having `currentHeight = 0` to flush out all remaining bars in the stack at the end of iteration.
2. **Monotonic Stack Processing:**
   - While the stack is non-empty (`top > 0`) and `currentHeight` is strictly less than the height of the bar at the top of the stack (`heights[stack[top - 1]]`), popped the top bar index (`stack[--top]`).
   - Calculated the width of the rectangle bounded by the popped bar height:
     - If the stack is empty (`top == 0`), the popped bar was the smallest seen so far, extending from index `0` to `i - 1` (width = `i`).
     - Otherwise, width extends between the current index `i` and the previous stack entry: `i - stack[top - 1] - 1`.
   - Updated `maxArea = Math.max(maxArea, height * width)`.
3. **Push Phase:** Pushed the current index `i` onto `stack` at `stack[top++]`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the number of bars in `heights`. Each index is pushed and popped from the stack at most once.
- **Space Complexity:** $O(N)$ auxiliary space for the pre-allocated fixed `stack` array.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrored the fixed-array index stack implementation using Python list pre-allocation and an explicit `top` pointer.

1. **Monotonic Index Stack:**
   - Pre-allocated `stack = [0] * (n + 1)` with `top = 0`.
   - Evaluated heights up to `range(n + 1)` with `current_height = 0 if i == n else heights[i]`.
2. **Width & Area Computation:**
   - Maintained an increasing monotonic stack of bar indices.
   - Popped elements when encountering a smaller bar and computed maximum rectangle area using `width = i if top == 0 else i - stack[top - 1] - 1`.
3. **Execution Harness:** Validated test scenarios in `main()` using `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ linear time.
- **Space Complexity:** $O(N)$ space for the fixed array stack.

---

## Notes/Explanation

- **Sentinel Element (`height = 0` at `i = n`):** Adding a zero-height sentinel at the end guarantees that all remaining indices stored in the stack are popped and processed before the loop finishes, eliminating the need for a separate cleanup loop.
- **Monotonic Stack Boundary Guarantee:** Index `stack[top - 1]` after popping represents the nearest bar to the left that is strictly shorter than the popped bar. Thus, the popped bar can extend rightward up to `i - 1` and leftward down to `stack[top - 1] + 1`.
