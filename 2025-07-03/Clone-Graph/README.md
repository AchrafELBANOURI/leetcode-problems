# Daily LeetCode Problem - $(date +%B\ %d,\ %Y)

## Problem

[133. Clone Graph](https://leetcode.com/problems/clone-graph/) - Medium

## Problem Statement

Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

### Examples

**Example 1:**
```
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
Node 1's value is 1, and it has neighbors 2 and 4.
Node 2's value is 2, and it has neighbors 1 and 3.
Node 3's value is 3, and it has neighbors 2 and 4.
Node 4's value is 4, and it has neighbors 1 and 3.
```

**Example 2:**
```
Input: adjList = [[]]
Output: [[]]
Explanation: The graph only contains one node with value 1 and it does not have any neighbors.
```

**Example 3:**
```
Input: adjList = []
Output: []
Explanation: The graph is empty.
```

### Constraints

- The number of nodes in the graph is in the range `[0, 100]`.
- `1 <= Node.val <= 100`
- `Node.val` is unique for each node.
- There are no repeated edges or self-loops in the graph.
- The graph is connected and undirected.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a depth-first search (DFS) approach to clone the graph. It employs a hash map to store the mapping between original nodes and their cloned counterparts. Starting from the given node, it recursively clones each neighbor and adds them to the cloned node's neighbors list. The hash map ensures that each node is cloned only once.

#### Complexity Analysis

- **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges. Each node and edge is visited once.
- **Space Complexity**: O(V), for the hash map used to store visited nodes.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also employs a depth-first search (DFS) approach. It uses a hash map to store the mapping between original nodes and their cloned counterparts. Starting from the given node, it recursively clones each neighbor and adds them to the cloned node's neighbors list. The hash map ensures that each node is cloned only once.

#### Complexity Analysis

- **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges. Each node and edge is visited once.
- **Space Complexity**: O(V), for the hash map used to store visited nodes.