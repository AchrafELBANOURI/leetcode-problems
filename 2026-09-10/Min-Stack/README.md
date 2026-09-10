# Daily LeetCode Problem - September 10, 2026

## Problem

[155. Min Stack](https://leetcode.com/problems/min-stack/)

## Problem Statement

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the `MinStack` class:

- `MinStack()` initializes the stack object.
- `void push(int val)` pushes the element `val` onto the stack.
- `void pop()` removes the element on the top of the stack.
- `int top()` gets the top element of the stack.
- `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with $O(1)$ time complexity for each function.

## Solutions

### Java Solution

Located in [`java/minStack/MinStack.java`](java/minStack/MinStack.java)

#### Approach

Implemented a custom singly linked list where each node maintains its value alongside a `prefixMin` snapshot representing the minimum value present in the stack at or below that node.

1. **Node Structure:**
   - `value`: Stores the current element data.
   - `prefixMin`: Stores $\min(\text{previous node's } prefixMin, \text{current value})$.
   - `next`: Points to the node directly below it in the stack.
2. **Operations:**
   - **`push(value)`:** Computes `minSoFar = Math.min(stack.prefixMin, value)` and prepends a new node to the top of the head pointer (`stack = new Node(value, minSoFar, stack)`).
   - **`pop()`:** Moves the head pointer down by one node (`stack = stack.next`).
   - **`top()`:** Returns `stack.value`.
   - **`getMin()`:** Returns `stack.prefixMin`.
3. **Dummy Node Sentinel:** Initialized with `Integer.MAX_VALUE` for both `value` and `prefixMin` to handle edge base cases gracefully without `null` checks on initial pushes.

#### Complexity Analysis

- **Time Complexity:** $O(1)$ for `push`, `pop`, `top`, and `getMin`.
- **Space Complexity:** $O(N)$ where $N$ is the total number of elements stored in the stack.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Utilized a secondary auxiliary stack (`min_stack`) parallel to the main element storage list to track prefix minimums across dynamic push and pop sequences.

1. **Parallel Tracking:**
   - **`push(val)`:** Appends `val` to `self.stack` and appends $\min(val, \text{current minimum})$ to `self.min_stack`.
   - **`pop()`:** Pops top elements simultaneously from both `self.stack` and `self.min_stack`.
   - **`top()`:** Accesses `self.stack[-1]`.
   - **`getMin()`:** Accesses `self.min_stack[-1]`.
2. **Execution Driver:** `Solution.operations` processes sequential operations array inputs and compares outputs against expected results using `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(1)$ constant time across all methods (`push`, `pop`, `top`, `getMin`).
- **Space Complexity:** $O(N)$ auxiliary space for storing minimum state history.

---

## Notes/Explanation

- **Prefix Minimum State:** By caching the minimum element cumulative to each node/level at insertion time, retrieving the minimum element takes $O(1)$ constant time without needing full stack scans.
- **Linked List vs Dual Lists:** The Java linked list approach encapsulates both data and minimum state inside a single unified `Node` object, ensuring pointer manipulation overhead replaces list re-allocations.
