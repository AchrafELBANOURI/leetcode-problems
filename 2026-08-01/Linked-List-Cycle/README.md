# Daily LeetCode Problem - August 07, 2026

## Problem

[LeetCode 141 - Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

## Problem Statement

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter.**

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

Used **Floyd’s Cycle-Finding Algorithm** (also known as the **Tortoise and the Hare algorithm**):

1. Check edge cases: if the list is empty (`head == null`) or has only one node without a cycle (`head.next == null`), return `false`.
2. Initialize two pointers: `slow` starting at `head` and `fast` starting at `head.next`.
3. Advance `slow` by 1 step (`slow = slow.next`) and `fast` by 2 steps (`fast = fast.next.next`) in a loop.
4. If `fast` or `fast.next` becomes `null`, the list terminates, meaning there is no cycle (return `false`).
5. If `slow == fast` at any point, the fast pointer caught up to the slow pointer, confirming a cycle exists (return `true`).

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(N)$, where $N$ is the total number of nodes in the linked list. If no cycle exists, `fast` reaches the end in $N/2$ steps. If a cycle exists, `fast` will catch up to `slow` within a distance proportional to the cycle length.
- **Space Complexity:** $\mathcal{O}(1)$, as only two pointer variables (`slow` and `fast`) are maintained regardless of list size.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

Implemented the identical **Floyd’s Cycle-Finding Algorithm** in Python:

1. Validate base cases (`head is None` or `head.next is None`).
2. Set up `slow = head` and `fast = head.next`.
3. Loop while `slow != fast`. Inside the loop, check if `fast` or `fast.next` reaches `None`. If so, return `False`.
4. Otherwise, advance `slow` by 1 position and `fast` by 2 positions.
5. If the loop terminates because `slow == fast`, return `True`.

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(N)$, traversing through at most $N$ nodes before detecting a cycle or hitting the end of the list.
- **Space Complexity:** $\mathcal{O}(1)$, memory usage is constant since no auxiliary data structures are used.

## Notes/Explanation

- **Why Floyd's Algorithm works:** If a cycle exists, the fast pointer enters the loop first. Once the slow pointer enters, the relative distance between `fast` and `slow` decreases by 1 step with every iteration ($2 - 1 = 1$). Therefore, `fast` is guaranteed to catch up to `slow` without endlessly looping.
- **Alternative Approach (Hash Set):** We could store node references in a Hash Set while traversing. If we hit a node already in the set, a cycle exists. While this takes $\mathcal{O}(N)$ time, it requires $\mathcal{O}(N)$ extra space, making the two-pointer approach optimal.
