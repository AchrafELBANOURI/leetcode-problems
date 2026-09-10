# Daily LeetCode Problem - September 10, 2026

## Problem

[895. Maximum Frequency Stack](https://leetcode.com/problems/maximum-frequency-stack/)

## Problem Statement

Design a stack-like data structure to push elements and pop the most frequent element from the stack.

Implement the `FreqStack` class:

- `FreqStack()` constructs an empty frequency stack.
- `void push(int val)` pushes an integer `val` onto the top of the stack.
- `int pop()` removes and returns the most frequent element in the stack.
  - If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

## Solutions

### Java Solution

Located in [`java/maximumFrequencyStack/FreqStack.java`](java/maximumFrequencyStack/FreqStack.java)

#### Approach

Used a two-map grouping structure to track element frequencies and maintain stack history per frequency level.

1. **State Tracking:**
   - `valueFreq`: A `HashMap<Integer, Integer>` to store the current frequency count of each unique value.
   - `frequencyLevels`: A `HashMap<Integer, Stack<Integer>>` mapping each frequency count to a stack of elements that reached that frequency level.
   - `maxFreq`: An integer variable tracking the current highest frequency.
2. **Push Operation (`push`):**
   - Incremented the frequency count of `val` in `valueFreq`.
   - Pushed `val` into the stack corresponding to its new frequency level in `frequencyLevels`.
   - Updated `maxFreq` if the new frequency exceeded the current `maxFreq`.
3. **Pop Operation (`pop`):**
   - Retrieved the stack for `maxFreq` and popped the top element (`mostFreqElement`).
   - Decremented the frequency count of `mostFreqElement` in `valueFreq`.
   - If the stack for `maxFreq` became empty, decremented `maxFreq`.
   - Returned `mostFreqElement`.

#### Complexity Analysis

- **Time Complexity:** $O(1)$ amortized for both `push` and `pop` operations.
- **Space Complexity:** $O(N)$ where $N$ is the total number of elements pushed into `FreqStack`.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Implemented `FreqStack` using `collections.defaultdict` to manage element frequencies and level-based stacks.

1. **Data Structures:**
   - `self.value_freq`: `defaultdict(int)` mapping values to their active frequency.
   - `self.frequency_levels`: `defaultdict(list)` storing values as stack lists at each frequency level.
   - `self.max_freq`: Integer tracking the maximum frequency present in the structure.
2. **Operations & Execution:**
   - `push(val)`: Calculates updated frequency, appends `val` to `frequency_levels[curr_val_freq]`, and updates `self.max_freq`.
   - `pop()`: Pops from `frequency_levels[self.max_freq]`, updates value frequency, decrements `self.max_freq` if the level stack becomes empty, and returns the popped element.
   - `Solution.operations`: Driver method parsing input command strings (`"push"`, `"pop"`) and executing validations via `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(1)$ time complexity for both `push` and `pop`.
- **Space Complexity:** $O(N)$ auxiliary space across hash maps and list stacks.

---

## Notes/Explanation

- **Handling Ties via Multi-Stack Grouping:** Grouping values into separate stacks by frequency level implicitly preserves element insertion order. When multiple values share the maximum frequency `maxFreq`, popping from `frequency_levels[maxFreq]` automatically yields the most recently pushed element among them, resolving tie-breakers in $O(1)$ without needing a heap or priority queue.
- **Lazy Stack Cleanup:** Level stacks at lower frequencies remain intact when popping from `maxFreq`. When a value's frequency decreases from $F$ to $F-1$, its previous entries in levels $1 \dots F-1$ remain available for future pops.
