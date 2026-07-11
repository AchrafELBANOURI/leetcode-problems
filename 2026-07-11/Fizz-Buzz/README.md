# Daily LeetCode Problem - July 9, 2026

## Problem

[412. Fizz Buzz](https://leetcode.com/problems/fizz-buzz/) - Easy

## Problem Statement

Given an integer `n`, return a string array `answer` (1-indexed) where:

- `answer[i] == "FizzBuzz"` if `i` is divisible by both `3` and `5`.
- `answer[i] == "Fizz"` if `i` is divisible by `3`.
- `answer[i] == "Buzz"` if `i` is divisible by `5`.
- `answer[i] == i` (as a string) if none of the above conditions are true.

### Examples

**Example 1:**

```text
Input: n = 3
Output: ["1","2","Fizz"]
```

**Example 2:**

```text
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
```

**Example 3:**

```text
Input: n = 15
Output:
["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
```

### Constraints

- `1 <= n <= 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution returns an anonymous implementation of `AbstractList<String>` instead of constructing an `ArrayList`.

The returned list is **lazy**: it does not store the Fizz Buzz strings in memory. Instead, each element is computed only when the `get(index)` method is called.

For every requested index:

1. Convert the zero-based index into the corresponding number (`index + 1`).
2. If the number is divisible by both `3` and `5`, return `"FizzBuzz"`.
3. Otherwise, if divisible by `3`, return `"Fizz"`.
4. Otherwise, if divisible by `5`, return `"Buzz"`.
5. Otherwise, return the number converted to a string.

The `size()` method simply returns `n`, allowing the object to behave like a normal list.

#### Complexity Analysis

- **Time Complexity:** **O(n)** if the entire list is traversed once.
- **Space Complexity:** **O(1)** extra space, since no list of strings is explicitly stored.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution constructs the answer eagerly using a list.

It iterates from `1` to `n` and appends:

- `"FizzBuzz"` if the number is divisible by both `3` and `5`.
- `"Buzz"` if divisible only by `5`.
- `"Fizz"` if divisible only by `3`.
- Otherwise, the number converted to a string.

After processing every number, the resulting list is returned.

#### Complexity Analysis

- **Time Complexity:** **O(n)**, since each integer from `1` to `n` is processed exactly once.
- **Space Complexity:** **O(n)**, as the output list stores `n` strings.

## Notes/Explanation

- The Java solution demonstrates the use of an **anonymous inner class** extending `AbstractList`.
- Unlike the Python solution, the Java implementation computes values **on demand** through the overridden `get()` method instead of storing them beforehand.
- Although this approach uses constant auxiliary memory, the overall memory used by the returned list depends on how it is consumed by the caller.
- Both implementations produce identical outputs while illustrating two different design philosophies: **lazy evaluation** (Java) versus **eager evaluation** (Python).
