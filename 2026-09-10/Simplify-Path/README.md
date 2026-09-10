# Daily LeetCode Problem - September 10, 2026

## Problem

[71. Simplify Path](https://leetcode.com/problems/simplify-path/)

## Problem Statement

Given an absolute path for a Unix-style file system, which begins with a slash `'/'`, transform it to the simplified canonical path.

In a Unix-style file system:

- A period `'.'` refers to the current directory.
- A double period `'..'` refers to the directory up a level.
- Any multiple consecutive slashes such as `'//'` and `'///'` are treated as a single slash `'/'`.
- Any sequence of periods that does not match `'.'` or `'..'` is treated as a valid directory or file name. For example, `'...'` and `'....'` are valid directory or file names.

The canonical path should have the following format:

- The path starts with a single slash `'/'`.
- Any two directories are separated by a single slash `'/'`.
- The path does not end with a trailing `'/'`.
- The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period `'.'` or double period `'..'`).

Return _the simplified canonical path_.

## Solutions

### Java Solution

Located in [`java/simplifyPath/Solution.java`](java/simplifyPath/Solution.java)

#### Approach

Used a custom fixed-size string array to simulate a stack, avoiding dynamic collection allocations.

1. **Splitting Path:** Split the input string using `"/"` as the delimiter into individual directory name tokens (`parts`).
2. **Stack Processing:**
   - Iterated over each component `p`.
   - Ignored empty strings (caused by consecutive slashes) and current directory indicators (`"."`).
   - For parent directory tokens (`".."`), decremented `top` pointer if `top > 0` (popped the last directory level).
   - For valid folder names, placed `p` into `stack[top]` and incremented `top`.
3. **Canonical Path Reconstruction:**
   - If `top == 0`, returned the root directory `"/"`.
   - Built the final path using `StringBuilder` by iterating from `0` to `top - 1` and appending `"/"` before each directory name.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the length of the `path` string. Splitting and processing the path takes linear time.
- **Space Complexity:** $O(N)$ to hold the split tokens and simulated string stack array.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrored the array-pointer stack approach using Python string splitting and list pre-allocation.

1. **Fixed Array Simulation:**
   - Pre-allocated a list of empty strings `stack = [""] * len(parts)` with pointer `top = 0`.
   - Filtered out empty segments and `"."` entries.
   - Handled directory navigation (`".."` pops the top element by decrementing `top`; valid directory names increment `top`).
2. **Path Joining:**
   - If `top == 0`, returned `"/"`.
   - Used `"/" + "/".join(stack[:top])` to construct the canonical path.
3. **Execution Driver:** Runs automated test cases in `main()` using `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(N)$ linear time.
- **Space Complexity:** $O(N)$ auxiliary space for storing path components in the stack.

---

## Notes/Explanation

- **Handling Edge Cases:**
  - **Multiple slashes (`//`):** `split("/")` generates empty string `""` components which are safely skipped.
  - **Root Boundary Protection (`/..`):** Attempting to navigate up from the root directory (`..` when `top == 0`) is ignored since `top` never drops below `0`.
- **Pre-allocated Stack Optimization:** Using a fixed array slice (`stack[:top]`) with a manual top pointer avoids dynamic list append/pop reallocations, ensuring predictable linear performance.
