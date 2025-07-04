# Daily LeetCode Problem - July 4, 2025

## Problem

[207. Course Schedule](https://leetcode.com/problems/course-schedule/) - Medium

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. Some courses may have prerequisites, for example, to take course `0` you have to first take course `1`, which is expressed as a pair: `[0, 1]`.

Given the total number of courses `numCourses` and a list of prerequisite pairs `prerequisites`, return `true` if you can finish all courses. Otherwise, return `false`.

### Examples

**Example 1:**
```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
```

**Example 2:**
```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should have finished course 1. So it is impossible.
```

### Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= 5000`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- All the pairs `[ai, bi]` are unique.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(V + E), where V is the number of courses and E is the number of prerequisites.
- **Space Complexity**: O(V + E), for the adjacency list and visited array.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(V + E), where V is the number of courses and E is the number of prerequisites.
- **Space Complexity**: O(V + E), for the adjacency list and visited array.