# Daily LeetCode Problem - July 9, 2026

## Problem

[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) - Easy

## Problem Statement

Given the `head` of a singly linked list, reverse the list, and return the reversed list.

### Examples

**Example 1:**

```text
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

**Example 2:**

```text
Input: head = [1,2]
Output: [2,1]
```

**Example 3:**

```text
Input: head = []
Output: []
```

### Constraints

- The number of nodes in the list is the range `[0, 5000]`.
- `-5000 <= Node.val <= 5000`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution reverses the linked list **iteratively** using three pointers:

- `prevNode` stores the previous node.
- `currNode` stores the current node being processed.
- `nextNode` temporarily stores the next node before modifying the current node's `next` pointer.

The algorithm traverses the list once. For each node:

1. Save the next node in `nextNode`.
2. Reverse the current node's pointer by making it point to `prevNode`.
3. Move `prevNode` forward to the current node.
4. Move `currNode` to `nextNode`.

Once all nodes have been processed, `prevNode` points to the new head of the reversed list and is returned.

For testing purposes, helper methods `build()` and `tearDown()` are included to convert between a list of integers and a linked list.

#### Complexity Analysis

- **Time Complexity:** **O(n)**, where `n` is the number of nodes in the linked list. Each node is visited exactly once.
- **Space Complexity:** **O(1)**, since the reversal is performed in-place using only three pointers.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution reverses the linked list **recursively**.

A helper function `proccess(currNode, prevNode)` is used to perform the reversal:

1. **Base Case:** If `currNode` is `None`, the recursion has reached the end of the list, so `prevNode` (the new head) is returned.
2. Store the next node in `nextNode`.
3. Reverse the current node's pointer by making it point to `prevNode`.
4. Recursively process the next node while passing the current node as the new previous node.

The recursion continues until the end of the list is reached, at which point the reversed list is returned.

Like the Java version, helper methods `build()` and `tearDown()` are provided to simplify testing.

#### Complexity Analysis

- **Time Complexity:** **O(n)**, since each node is visited exactly once.
- **Space Complexity:** **O(n)**, due to the recursive call stack.

## Notes/Explanation

- The Java implementation demonstrates the **iterative** approach, which is generally preferred in interviews because it uses constant extra space.
- The Python implementation demonstrates the **recursive** approach, offering a concise and elegant solution at the cost of additional stack space.
- Both approaches correctly handle:
  - An empty linked list.
  - A linked list containing a single node.
  - A linked list containing multiple nodes.
- Both solutions produce the same reversed linked list while illustrating two common techniques for solving this classic linked list problem.
