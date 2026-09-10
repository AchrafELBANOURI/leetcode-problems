# Daily LeetCode Problem - September 10, 2026

## Problem

[232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

## Problem Statement

Implement a first-in-first-out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (`push`, `peek`, `pop`, and `empty`).

Implement the `MyQueue` class:

- `void push(int x)` Pushes element x to the back of the queue.
- `int pop()` Removes the element from the front of the queue and returns it.
- `int peek()` Returns the element at the front of the queue.
- `boolean empty()` Returns `true` if the queue is empty, `false` otherwise.

**Notes:**

- You must use only standard operations of a stack, which means only `push to top`, `peek/pop from top`, `size`, and `is empty` operations are valid.

## Solutions

### Java Solution

Located in [`java/implementQueueUsingStacks/Solution.java`](java/implementQueueUsingStacks/Solution.java)

#### Approach

Simulated FIFO behavior by transferring elements between a primary storage stack (`stack`) and a temporary swap stack (`swap`).

1. **`push(x)`:** Pushes element `x` directly onto `stack` in $O(1)$ time.
2. **`pop()`:**
   - Transfers $N - 1$ elements from `stack` into `swap` by popping from `stack` and pushing onto `swap`.
   - Pops and records the bottom-most element (`top`) from `stack`.
   - Restores the original element order by pushing all $N - 1$ elements back from `swap` to `stack`.
   - Resets `swap = new Stack<>()` and returns `top`.
3. **`peek()`:**
   - Moves $N - 1$ elements from `stack` to `swap`.
   - Pops the bottom-most element, pushes it onto `swap`, and restores all $N$ elements back onto `stack`.
   - Resets `swap` and returns the front element.
4. **`empty()`:** Returns `stack.empty()` in $O(1)$ time.

#### Complexity Analysis

- **Time Complexity:**
  - `push`: $O(1)$
  - `pop`: $O(N)$
  - `peek`: $O(N)$
  - `empty`: $O(1)$
- **Space Complexity:** $O(N)$ total space used across `stack` and auxiliary `swap`.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrors the primary/swap stack approach using Python's dynamic list structure acting as standard LIFO stacks (`append` and `pop`).

1. **Stack Transfer Mechanics:**
   - `push`: Appends `x` directly to `self.stack`.
   - `pop`: Pops $N - 1$ elements into `self.swap`, isolates the bottom element, transfers elements back to `self.stack`, and clears `self.swap`.
   - `peek`: Transfers $N - 1$ elements to `self.swap`, reads the front element, restores all elements to `self.stack`, and returns the front value.
   - `empty`: Returns `len(self.stack) == 0`.
2. **Execution Harness:** `Solution.operations` processes sequential string operations (`push`, `pop`, `peek`, `empty`) and verifies expected output arrays via `assert_test`.

#### Complexity Analysis

- **Time Complexity:**
  - `push`: $O(1)$
  - `pop`: $O(N)$
  - `peek`: $O(N)$
  - `empty`: $O(1)$
- **Space Complexity:** $O(N)$ auxiliary space for stack arrays.

---

## Notes/Explanation

- **LIFO to FIFO Reversal:** Transferring elements sequentially between two stacks reverses their order twice, allowing access to the oldest element (the bottom of the primary stack) while preserving state.
- **Amortized Optimization Alternative:** Instead of transferring elements back and forth on every `pop` and `peek` call ($O(N)$ per operation), an amortized $O(1)$ approach can be achieved by keeping `input` and `output` stacks separate, popping from `output` until empty before refilling it from `input`.
