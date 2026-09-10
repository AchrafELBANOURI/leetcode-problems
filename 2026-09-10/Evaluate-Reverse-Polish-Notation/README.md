# Daily LeetCode Problem - September 10, 2026

## Problem

[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

## Problem Statement

You are given an array of strings `tokens` that represents an arithmetic expression in Reverse Polish Notation (Postfix Notation).

Evaluate the expression. Return _an integer that represents the value of the expression_.

**Note that:**

- The valid operators are `'+'`, `'-'`, `'*'`, and `'/'`.
- Each operand may be an integer or another expression.
- The division between two integers always **truncates toward zero**.
- There will not be any division by zero.
- The input represents a valid arithmetic expression in reverse polish notation.
- The answer and all the intermediate calculations can be represented in a **32-bit** integer.

## Solutions

### Java Solution

Located in [`java/evalRPN/Solution.java`](java/evalRPN/Solution.java)

#### Approach

Used a fixed-size primitive integer array to simulate a stack, avoiding wrapper class overhead and dynamic memory allocation.

1. **Fixed Array Stack:** Pre-allocated an integer array `stack` of size `tokens.length` with a pointer `top = 0`.
2. **Switch Dispatch:**
   - For operators (`"+"`, `"-"`, `*`, `"/"`), evaluated the operation using the top two elements (`stack[top - 2]` and `stack[top - 1]`), stored the result back at `stack[top - 2]`, and decremented `top`.
   - For operands (`default`), parsed the integer value, placed it at `stack[top]`, and incremented `top`.
3. **Result Retrieval:** Returned `stack[top - 1]`, which contains the final evaluation result.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the length of `tokens`. Each token is evaluated in $O(1)$ constant time.
- **Space Complexity:** $O(N)$ for allocating the fixed-size `stack` array.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrored the array-based fixed stack approach using a pre-allocated Python list and pattern matching.

1. **Pre-allocated List & Pointer:** Initialized `stack = [0] * len(tokens)` with `top = 0`.
2. **Pattern Matching (`match/case`):**
   - Performed in-place arithmetic on `stack[top - 2]` and `stack[top - 1]`.
   - For division (`"/"`), used `int(stack[top - 2] / stack[top - 1])` to guarantee truncation toward zero (matching C/Java integer division semantics instead of Python's floor division `//`).
   - Parsed integer literals into `stack[top]` and incremented `top`.
3. **Execution Driver:** Ran test cases through `sol.evalRPN` and verified outputs via `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the number of tokens.
- **Space Complexity:** $O(N)$ for the pre-allocated fixed-length list.

---

## Notes/Explanation

- **Truncation Behavior:** In Python, standard integer division (`//`) performs floor division (rounding down toward $-\infty$), which yields incorrect results for negative operands (e.g., `-3 // 2 == -2`). Using `int(a / b)` correctly truncates toward zero (e.g., `int(-3 / 2) == -1`), matching standard C/Java behavior required by the problem statement.
- **Fixed Array Performance:** Pre-allocating an array based on `tokens.length` eliminates dynamic list/stack resizing, guaranteeing minimal overhead and optimal execution speed.
