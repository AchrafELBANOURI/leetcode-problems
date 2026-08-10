package bestTimeToBuyAndSellStockII;

import utilities.TestUtils;

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0 ;
        int localProfit = 0 ;
        for(int i = 1 ; i < prices.length ; i++){
            localProfit = prices[i] - prices[i-1];
            if( localProfit > 0 ){
                profit += localProfit;
            }
        }

        return profit;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] prices_1 = {7,1,5,3,6,4};        
        int output1 = sol.maxProfit(prices_1);
        int expected1 = 7;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );
        
        // Test Case 2
        int[] prices_2 = {1,2,3,4,5};        
        int output2 = sol.maxProfit(prices_2);
        int expected2 = 4;
        
        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        int[] prices_3 = {7,6,4,3,1};        
        int output3 = sol.maxProfit(prices_3);
        int expected3 = 0;
        
        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );
    }
}
