# Daily LeetCode Problem - June 14, 2025

## Problem

[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) - Easy

## Problem Statement

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

### Examples

**Example 1:**

```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

**Example 2:**

```
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

### Constraints

- `1 <= n <= 45`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a dynamic programming approach. An array `prev` is used to store the number of ways to reach each step. For steps 0 to 3, the values are initialized directly since they are straightforward. For steps greater than 3, the value is calculated as the sum of the ways to reach the two previous steps (`prev[i-1] + prev[i-2]`).

```java
public int climbStairs(int n) {
    int[] prev = new int[n+1];
    for(int i = 0; i < n+1; i++) {
        if (i < 4) {
            prev[i] = i;
        } else {
            prev[i] = prev[i-1] + prev[i-2];
        }
    }
    return prev[n];
}
```

#### Complexity Analysis

- **Time Complexity**: O(n) - We compute the result for each step from 1 to n.
- **Space Complexity**: O(n) - An array of size n+1 is used to store intermediate results.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses a dynamic programming approach. A list `prev_steps` is initialized to store the number of ways to reach each step. For steps 0 to 3, the values are directly assigned. For steps greater than 3, the value is calculated as the sum of the ways to reach the two previous steps (`prev_steps[i-1] + prev_steps[i-2]`).

```python
def climbStairs(n: int) -> int:
    prev_steps = [i for i in range(n+1)]
    for i in range(4, n+1):
        prev_steps[i] = prev_steps[i-1] + prev_steps[i-2]
    return prev_steps[n]
```

#### Complexity Analysis

- **Time Complexity**: O(n) - We compute the result for each step from 1 to n.
- **Space Complexity**: O(n) - A list of size n+1 is used to store intermediate results.

## Notes/Explanation

This implementation is another approach to solving the problem, which I liked the most even better than mine. It uses two variables instead of an array to store intermediate results, achieving the same time complexity of O(n) but with a space complexity of O(1):

```java
public int climbStairs(int n) {
    int one = 1;
    int two = 1;
    for (int i = 1; i < n; i++) {
        int temp = one;
        one = one + two;
        two = temp;
    }
    return one;
}
```
