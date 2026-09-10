# Daily LeetCode Problem - September 10, 2026

## Problem

[735. Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)

## Problem Statement

We are given an array `asteroids` of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

## Solutions

### Java Solution

Located in [`java/asteroidCollision/Solution.java`](java/asteroidCollision/Solution.java)

#### Approach

Used an explicit fixed-size primitive integer array to simulate stack push and pop mechanics without the memory overhead of `java.util.Stack`.

1. **Collision Logic:**
   - Iterated through each asteroid (`ast`) in the array.
   - Evaluated collision conditions within a `while` loop: collisions only occur if the current top asteroid on the stack moves right (`stack[top - 1] > 0`) and the incoming asteroid moves left (`ast < 0`).
   - If sizes are equal (`topSize == astSize`), both asteroids explode (`top--` and `destroyed = true`).
   - If the stack top is smaller (`topSize < astSize`), the top asteroid is destroyed (`top--`), and the incoming asteroid continues checking prior elements on the stack.
   - If the stack top is larger (`topSize > astSize`), the incoming asteroid explodes (`destroyed = true`).
2. **Push Phase:** If the incoming asteroid survived all collisions (`!destroyed`), placed it at `stack[top]` and incremented `top`.
3. **Array Trimming:** Used `System.arraycopy` to trim the `stack` array down to the active size `top`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the length of `asteroids`. Each asteroid is pushed onto the stack and popped at most once.
- **Space Complexity:** $O(N)$ for the pre-allocated fixed `stack` array.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Implemented the same explicit array index pointer technique using a pre-allocated Python list.

1. **Fixed Array Simulation:**
   - Maintained `stack = [0] * len(asteroids)` with `top = 0`.
   - Processed each asteroid through collision resolution checks using `abs(ast)`.
   - Set boolean flags (`destroyed`) to track whether the incoming negative-moving asteroid survived stack collisions.
2. **Slice Trimming:** Used Python list slicing `stack[:top]` to construct the result array in linear time.
3. **Execution Harness:** Executed parameterized test suites using dynamically generated `main()` test blocks and validated output using `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the number of asteroids.
- **Space Complexity:** $O(N)$ auxiliary space for the fixed array stack.

---

## Notes/Explanation

- **Collision Right-to-Left Dependency:** Collisions can only happen when a right-moving asteroid (`> 0`) is followed by a left-moving asteroid (`< 0`). Left-moving asteroids occurring before any right-moving ones never collide and pass safely onto the stack.
- **Index-Pointer Stack Optimization:** Using an integer pointer `top` over dynamic list modifications (`pop()` / `append()`) avoids slice re-allocations during iteration, yielding deterministic $O(N)$ linear performance.
