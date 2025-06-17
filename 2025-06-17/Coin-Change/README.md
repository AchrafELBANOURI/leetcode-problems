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

The Java solution uses a dynamic programming approach. An array `arr` is initialized with a size of `amount + 1` and filled with a value of `amount + 1` to represent an unreachable state. The value at index 0 is set to 0, as no coins are needed to make an amount of 0. For each coin in the `coins` array, the algorithm iterates through all amounts from the coin's value to `amount`, updating the minimum number of coins required to make up that amount.

#### Complexity Analysis

- **Time Complexity**: O(amount * coins.length) - For each amount from 0 to `amount`, we iterate through all the coins to find the minimum number of coins required.
- **Space Complexity**: O(amount) - We use a DP array of size `amount + 1` to store intermediate results.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also uses a dynamic programming approach. A list `arr` is initialized with a size of `amount + 1` and filled with a value of `amount + 1` to represent an unreachable state. The value at index 0 is set to 0, as no coins are needed to make an amount of 0. For each coin in the `coins` list, the algorithm iterates through all amounts from the coin's value to `amount`, updating the minimum number of coins required to make up that amount.

#### Complexity Analysis

- **Time Complexity**: O(amount * coins.length) - For each amount from 0 to `amount`, we iterate through all the coins to find the minimum number of coins required.
- **Space Complexity**: O(amount) - We use a DP array of size `amount + 1` to store intermediate results.
