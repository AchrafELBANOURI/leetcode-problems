# Daily LeetCode Problem - September 10, 2026

## Problem

[394. Decode String](https://leetcode.com/problems/decode-string/)

## Problem Statement

Given an encoded string, return its decoded string.

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, `k`. For example, there will not be input like `3a` or `2[4]`.

The test cases are generated so that the length of the output will never exceed $10^5$.

## Solutions

### Java Solution

Located in [`java/decodeString/Solution.java`](java/decodeString/Solution.java)

#### Approach

Used two explicit stacks (`Deque`) to manage nested bracket structures: one for numeric repetition counts (`countStack`) and another for outer context string builders (`stringStack`).

1. **State Tracking:** Maintained running variables `currentNum` for multi-digit parsing and `currentString` for building content at the current nesting level.
2. **Character Processing:**
   - **Digit (`'0'`–`'9'`):** Built multi-digit integers iteratively (`currentNum = currentNum * 10 + (c - '0')`).
   - **Open Bracket (`'['`):** Pushed `currentNum` and `currentString` onto their respective stacks to save outer context, then reset state for the inside scope.
   - **Close Bracket (`']'`):** Popped the repeat count and previous string context. Appended `currentString` repeated `repeatCount` times to `prevString`, then restored `currentString = prevString`.
   - **Character (`'a'`–`'z'`):** Appended regular characters directly to `currentString`.
3. **Return:** Returned `currentString.toString()`.

#### Complexity Analysis

- **Time Complexity:** $O(N + M)$ where $N$ is the length of the string `s` and $M$ is the total length of the decoded output string.
- **Space Complexity:** $O(N + M)$ to store the stack frames for nested brackets and the generated output string.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrored the two-stack algorithm using Python native dynamic lists, optimizing string concatenation by using list buffers (`List[str]`) for intermediate strings.

1. **Stack Representation:**
   - `count_stack`: Stores integer repeat counts (`List[int]`).
   - `string_stack`: Stores outer scope string buffers (`List[List[str]]`).
2. **Scope Resolution:**
   - When encountering `']'`, popped the preceding string buffer `prev_string` and count `repeat_count`.
   - Used `"!"` inner string join multiplied by `repeat_count` via Python sequence multiplication (`"".join(current_string) * repeat_count`) and appended it directly to `prev_string`.
3. **Execution Driver:** Runs automated unit tests in `main()` using `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(N + M)$ linear processing time relative to input length and expanded output length.
- **Space Complexity:** $O(N + M)$ auxiliary stack memory.

---

## Notes/Explanation

- **Nested Expressions (`3[a2[c]]`):** The stack structure naturally handles deep nesting by preserving parent states before entering a new bracket level (`'['`) and merging child results back into the parent frame upon exit (`']'`).
- **Multi-digit Numbers (`100[leetcode]`):** `current_num = current_num * 10 + digit` ensures numbers with multiple digits are computed accurately before pushing onto `count_stack`.
