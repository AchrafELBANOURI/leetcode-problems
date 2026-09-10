# Daily LeetCode Problem - September 10, 2026

## Problem

[225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

## Problem Statement

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (`push`, `top`, `pop`, and `empty`).

Implement the `MyStack` class:

- `void push(int x)` Pushes element x to the top of the stack.
- `int pop()` Removes the element on the top of the stack and returns it.
- `int top()` Returns the element on the top of the stack, without removing it.
- `boolean empty()` Returns `true` if the stack is empty, `false` otherwise.

**Notes:**

- You must use only standard operations of a queue, which means only `push to back`, `peek/pop from front`, `size`, and `is empty` operations are valid.

## Solutions

### Java Solution

Located in [`java/implementStackUsingQueues/Solution.java`](java/implementStackUsingQueues/Solution.java)

#### Approach

Implemented support for two strategies to simulate LIFO behavior using FIFO queue structures via a common interface `StackI`:

1. **One Queue Strategy (`OneQueueStack`):**
   - **`push(x)`:** Appends `x` directly to the queue in $O(1)$ time.
   - **`pop()`:** Rotates the queue $N - 1$ times by polling from the front and offering back to the rear, bringing the last inserted element to the front before polling it in $O(N)$ time.
   - **`top()`:** Rotates $N - 1$ elements to reach the back element, polls it, offers it back to retain state, and returns the value in $O(N)$ time.
   - **`empty()`:** Checks if the underlying queue is empty in $O(1)$ time.
2. **Two Queues Strategy (`TwoQueuesStack`):**
   - Uses a secondary queue to buffer elements during popping or pushing operations.
3. **Execution Harness:** `Solution.operations` handles string-based execution drivers for both strategy variants.

#### Complexity Analysis

- **Time Complexity:**
  - `push`: $O(1)$
  - `pop`: $O(N)$
  - `top`: $O(N)$
  - `empty`: $O(1)$
- **Space Complexity:** $O(N)$ where $N$ is the total number of elements present in the stack.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Implements the single queue rotational strategy using Python's double-ended queue (`collections.deque`).

1. **Queue Rotations:**
   - `push`: Uses `self.queue.append(x)` to enqueue elements.
   - `pop`: Obtains the queue size $N$, rotates $N - 1$ elements using `self.queue.append(self.queue.popleft())`, and pops the last inserted element with `self.queue.popleft()`.
   - `top`: Rotates $N - 1$ elements, records `top_val = self.queue.popleft()`, re-enqueues it to preserve order, and returns `top_val`.
   - `empty`: Evaluates `not self.queue`.
2. **Test Runner:** Uses `Solution.operations` dispatcher to execute batch test operations and verifies results using `assert_test`.

#### Complexity Analysis

- **Time Complexity:**
  - `push`: $O(1)$
  - `pop`: $O(N)$
  - `top`: $O(N)$
  - `empty`: $O(1)$
- **Space Complexity:** $O(N)$ to store queued elements.

---

## Notes/Explanation

- **Rotation Mechanism:** By re-enqueuing $N - 1$ elements back into the queue, the element at the back (most recently added) moves to the front, fulfilling the LIFO contract using standard $O(1)$ FIFO operations (`popleft` and `append`).
- **Cost Tradeoff:** This design favors $O(1)$ fast pushes at the expense of $O(N)$ pops and top reads. Alternatively, one could perform the $O(N)$ rotation step during `push` to make `pop` and `top` $O(1)$.
