# Daily LeetCode Problem - August 10, 2026

## Problem

[LeetCode 122 - Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

## Problem Statement

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the $i^{\text{th}}$ day.

On each day, you may decide to buy and/or sell the stock. You can only hold **at most one** share of the stock at any time. However, you can buy it then immediately sell it on the **same day**.

Find and return the **maximum profit** you can achieve.

## Solutions

### Java Solution

Located in [`java/bestTimeToBuyAndSellStockII/Solution.java`](java/bestTimeToBuyAndSellStockII/Solution.java)

#### Approach

This solution utilizes a **Greedy Approach**. Since we can perform unlimited transactions without transaction fees, we can capture every single upward price movement.

1. Iterate through the `prices` array starting from day $1$ (index $1$).
2. Calculate `localProfit` as the difference between the current day's price and the previous day's price (`prices[i] - prices[i - 1]`).
3. If `localProfit > 0`, add it to `profit`.
4. Return the total accumulated `profit`.

#### Complexity Analysis

- **Time Complexity:** $O(n)$ — Single pass through the `prices` array of length $n$.
- **Space Complexity:** $O(1)$ — Only maintains two integer variables (`profit` and `localProfit`).

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python implementation mirrors the greedy local profit accumulation:

1. Iterate from $i = 1$ to $n - 1$.
2. Compute `local_profit = prices[i] - prices[i - 1]`.
3. Accumulate `local_profit` whenever it is positive.

#### Complexity Analysis

- **Time Complexity:** $O(n)$ — Single traversal of the stock prices array.
- **Space Complexity:** $O(1)$ — Uses constant extra space.

---

## Notes/Explanation

- **Why the Greedy Strategy Works:** Buying at day $i-1$ and selling at day $i$ for all price increases is mathematically equivalent to buying at the trough of a consecutive price rise and selling at the peak. For example, $(p_3 - p_2) + (p_2 - p_1) = p_3 - p_1$.
- **No Penalty for Same-Day Transactions:** Since you can buy and sell on the same day, any price drop can be bypassed simply by not making a transaction for that day step.
