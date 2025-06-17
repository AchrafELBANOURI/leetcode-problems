import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill( arr , amount+1 );
        arr[0] = 0;

        for( int c : coins ){
            for( int i = c ; i < amount + 1 ; i++ ){
                arr[i] = Math.min( arr[i] , arr[i-c] + 1 );
            }
        }
        
        return arr[amount] != amount+1 ? arr[amount] : -1;
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(new Solution().coinChange(coins1, amount1)); // Expected: 3

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(new Solution().coinChange(coins2, amount2)); // Expected: -1

        // Test Case 3
        System.out.println("Test Case 3:");
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(new Solution().coinChange(coins3, amount3)); // Expected: 0

        // Test Case 4
        System.out.println("Test Case 4:");
        int[] coins4 = {1};
        int amount4 = 1;
        System.out.println(new Solution().coinChange(coins4, amount4)); // Expected: 1
    }
}
