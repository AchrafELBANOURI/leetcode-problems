# Daily LeetCode Problem - June 17, 2025

## Problem

[322. Coin Change](https://leetcode.com/problems/coin-change/) - Medium

## Problem Statement

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

### Examples

**Example 1:**

```
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

**Example 2:**

```
Input: coins = [2], amount = 3
Output: -1
```

**Example 3:**

```
Input: coins = [1], amount = 0
Output: 0
```

**Example 4:**

```
Input: coins = [1], amount = 1
Output: 1
```

**Example 5:**

```
Input: coins = [1], amount = 2
Output: 2
```

### Constraints

- `1 <= coins.length <= 12`
- `1 <= coins[i] <= 2^31 - 1`
- `0 <= amount <= 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(amount * coins.length) - For each amount from 0 to `amount`, we iterate through all the coins to find the minimum number of coins required.
- **Space Complexity**: O(amount) - We use a DP array of size `amount + 1` to store intermediate results.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(amount * coins.length) - For each amount from 0 to `amount`, we iterate through all the coins to find the minimum number of coins required.
- **Space Complexity**: O(amount) - We use a DP array of size `amount + 1` to store intermediate results.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
