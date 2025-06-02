import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        Solution s = new Solution();
        int result1 = s.maxProfit(prices);
        System.out.println("Case 1 : max Profit = " + result1);

        // Test Case 2
        System.out.println("Test Case 2:");
        prices = new int[] { 7, 6, 4, 3, 1 };
        s = new Solution();
        int result2 = s.maxProfit(prices);
        System.out.println("Case 2 : max Profit = " + result2);
    }
}
