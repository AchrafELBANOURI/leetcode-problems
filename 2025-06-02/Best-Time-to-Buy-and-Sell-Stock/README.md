# Daily LeetCode Problem - June 02, 2025

## Problem

[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) - Easy

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

### Examples

**Example 1:**

```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

**Example 2:**

```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done, and the max profit = 0.
```

### Constraints

- 1 <= prices.length <= 10^5
- 0 <= prices[i] <= 10^4

### Follow-up

Can you come up with an algorithm that runs in O(n) time complexity?

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a single-pass approach to find the maximum profit:

1. Initialize variables `buy` to the first price, `sell` to the second price, and `maxProfit` to 0.
2. Iterate through the array starting from the second price:
   - Calculate the profit as `sell - buy`.
   - If the profit is positive and greater than `maxProfit`, update `maxProfit`.
   - If the profit is negative, update `buy` to the current price and `sell` to the next price.
3. Return `maxProfit` after the loop.

This approach ensures that we only traverse the array once, keeping the time complexity linear.

#### Complexity Analysis

- Time Complexity: O(n) - we traverse the array only once
- Space Complexity: O(1) - no additional space is used

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution uses a two-pointer approach to find the maximum profit:

1. Initialize `min_price` to a very large value and `max_profit` to 0.
2. Iterate through the array:
   - Update `min_price` to the minimum of the current price and `min_price`.
   - Calculate the profit as the difference between the current price and `min_price`.
   - Update `max_profit` to the maximum of the current profit and `max_profit`.
3. Return `max_profit` after the loop.

This approach ensures that we efficiently track the minimum price and maximum profit in a single pass.

#### Complexity Analysis

- Time Complexity: O(n) - we only need to iterate through the array once
- Space Complexity: O(1) - no additional space is used

## Notes/Explanation

<!-- Add any additional notes or explanations here -->
