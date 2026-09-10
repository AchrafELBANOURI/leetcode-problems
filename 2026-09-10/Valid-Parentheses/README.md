# Daily LeetCode Problem - September 10, 2026

## Problem

[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

## Solutions

### Java Solution

Located in [`java/validParentheses/Solution.java`](java/validParentheses/Solution.java)

#### Approach

Used a stack-based Last-In, First-Out (LIFO) tracking mechanism using `ArrayDeque`.

1. **Stack Initialization:** Created a `Deque<Character>` stack to track incoming opening brackets.
2. **Character Processing:**
   - Iterates through `s.toCharArray()`.
   - Pushes opening brackets (`'('`, `'{'`, `'['`) onto the stack.
   - For closing brackets (`')'`, `'}'`, `']'`), verifies if the stack is non-empty before popping the top character (`openBracket`).
   - Validates whether the popped `openBracket` matches the expected pair for the current closing bracket.
3. **Validation:** Checks `stack.isEmpty()` at the end to ensure no unmatched opening brackets remain.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the length of string `s`. Each character is pushed and popped at most once.
- **Space Complexity:** $O(N)$ in the worst case where all characters are opening brackets stored on the stack.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Follows the stack-based tracking pattern using a standard Python dynamic `list`.

1. **Stack & Iteration:** Iterates through each character in string `s` using a local `stack` list.
2. **Bracket Matching:**
   - Appends opening brackets (`'('`, `'{'`, `'['`) to the stack.
   - For closing brackets, returns `False` immediately if `len(stack) == 0`.
   - Pops the top element (`openBracket = stack.pop()`) and checks for mismatches against corresponding closing bracket types (`')'`, `']'`, `'}'`).
3. **Final Check:** Returns `True` if `len(stack) == 0` after processing all characters; otherwise `False`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the length of string `s`.
- **Space Complexity:** $O(N)$ to hold opening characters on the stack list.

---

## Notes/Explanation

- **LIFO Bracket Order:** Stacks naturally handle nested bracket structures by matching the most recent opening bracket with the first encountered closing bracket.
- **Early Exit Safeguards:** Checking for empty stack conditions before popping prevents runtime index errors when encountering dangling closing brackets (e.g., `"]"` or `")("`).
- **Data Structure Choice:** `ArrayDeque` in Java provides better memory locality and performance compared to `java.util.Stack`.
