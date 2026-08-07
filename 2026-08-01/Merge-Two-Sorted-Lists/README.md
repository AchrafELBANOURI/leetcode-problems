# Daily LeetCode Problem - Merge Two Sorted Lists

## Problem

[LeetCode 21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

## Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return _the head of the merged linked list_.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

We use an **Iterative Two-Pointer Approach** with a dummy head node:

1. Create a `dummy` node to act as the start anchor and a `tail` pointer initialized to `dummy`.
2. Iterate using a `while` loop while both `list1` and `list2` are not `null`:
   - Compare `list1.val` and `list2.val`.
   - Append the node with the smaller value to `tail.next`.
   - Advance the pointer (`list1` or `list2`) whose node was attached, and move `tail` forward.
3. Once one list becomes empty, attach the remaining non-null list directly to `tail.next`.
4. Return `dummy.next` as the new head of the merged list.

Helper methods included in `ListNode`:

- `build(List<Integer> values)`: Builds a linked list right-to-left from a list of integers.
- `tearDown(ListNode head)`: Converts a linked list back into a standard `List<Integer>` for easy testing/printing.

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(M + N)$ — Where $M$ and $N$ are the lengths of `list1` and `list2`. Every iteration advances at least one pointer, visiting each node at most once.
- **Space Complexity:** $\mathcal{O}(1)$ — The merge is done in-place by updating pointer links. Only a few reference variables (`dummy` and `tail`) are created.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python implementation mirrors the iterative two-pointer technique with a dummy node:

1. Initialize `dummy = ListNode()` and `tail = dummy`.
2. Loop while `list1 is not None` and `list2 is not None`:
   - Point `tail.next` to the smaller of `list1` or `list2`.
   - Advance the chosen list pointer and `tail`.
3. Link any remaining nodes from `list1` or `list2` directly to `tail.next`.
4. Static methods `build` and `tear_down` are implemented on `ListNode` to handle array-to-linked-list conversion for test cases.

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(M + N)$ — Linear time complexity proportional to the total number of elements across both lists.
- **Space Complexity:** $\mathcal{O}(1)$ — In-place pointer updates ensure constant auxiliary space.

## Notes/Explanation

### Key Insights

- **Dummy Head Pattern:** Using a `dummy` sentinel node simplifies edge cases where the initial merged head might change, eliminating the need for conditional logic to handle the very first element.
- **In-Place Splicing:** Rather than creating new `ListNode` instances during the merge process, we re-link existing nodes, keeping memory overhead at $\mathcal{O}(1)$.
- **Recursive Alternative:** This problem can also be solved recursively:
  ```python
  def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
      if not l1 or not l2:
          return l1 or l2
      if l1.val < l2.val:
          l1.next = self.mergeTwoLists(l1.next, l2)
          return l1
      else:
          l2.next = self.mergeTwoLists(l1, l2.next)
          return l2
  ```
- **Note:** While clean, the recursive approach uses $\mathcal{O}(M + N)$ call stack space.
