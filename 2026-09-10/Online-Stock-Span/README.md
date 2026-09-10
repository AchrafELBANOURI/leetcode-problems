# Daily LeetCode Problem - September 10, 2026

## Problem

[901. Online Stock Span](https://leetcode.com/problems/online-stock-span/)

## Problem Statement

Design an algorithm that collects daily price quotes for some stock and returns **the span** of that stock's price for the current day.

The **span** of the stock's price in a given day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

- For example, if the prices of the stock in the last 4 days were `[7, 1, 2, 3]` and the price of the stock today is `3`, then the span of today is `4` because starting from today, the price was less than or equal to `3` for `4` consecutive days.
- Also, if the prices of the stock in the last 4 days were `[7, 34, 1, 2]` and the price of the stock today is `8`, then the span of today is `3` because starting from today, the price was less than or equal to `8` for `3` consecutive days.

Implement the `StockSpanner` class:

- `StockSpanner()` Initializes the object of the class.
- `int next(int price)` Returns the span of the stock's price given the current day's `price`.

## Solutions

### Java Solution

Located in [`java/onlineStockSpan/StockSpanner.java`](java/onlineStockSpan/StockSpanner.java)

#### Approach

Used a monotonically decreasing stack that stores pairs of `[price, span]` to aggregate spans of previously dominated consecutive days in $O(1)$ amortized time.

1. **Monotonic Stack Pairs:**
   - Maintained a stack where each element represents a stock price and its calculated cumulative span.
2. **Span Aggregation:**
   - For each incoming `price`, initialized `span = 1`.
   - While the stack is not empty and the top element's price is $\le$ current `price`, popped the top entry and accumulated its span: `span += stack.pop().span`.
3. **Push & Return:**
   - Pushed `[price, span]` back onto the stack and returned `span`.

#### Complexity Analysis

- **Time Complexity:** $O(1)$ amortized per `next()` call. Each price is pushed and popped from the stack at most once across the entire sequence.
- **Space Complexity:** $O(N)$ where $N$ is the total number of calls made to `next()`.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Implemented the `StockSpanner` class using a Python list as a stack storing two-element lists `[price, span]`.

1. **Stack Maintenance:**
   - Set initial `span = 1` on each invocation of `next(price)`.
   - Monotonically popped elements while `self.stack[-1][0] <= price`, accumulating `span += popped_entry[1]`.
   - Appended `[price, span]` to `self.stack` and returned `span`.
2. **Operations Driver:** `Solution.operations` handles string command parsing (`StockSpanner`, `next`) and runs assertions via `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(1)$ amortized time per `next(price)` operation.
- **Space Complexity:** $O(N)$ space to maintain the stack elements across $N$ queries.

---

## Notes/Explanation

- **Span Compression:** Instead of traversing back day-by-day (which takes $O(N)$ worst-case per query), pushing `[price, span]` pairs compresses all contiguous smaller/equal previous days into a single stack entry.
- **Monotonic Property:** Prices on the stack remain strictly decreasing from bottom to top. Once a price is popped by a higher current price, its span is safely absorbed into the higher price's span and never needs to be re-examined individually.
