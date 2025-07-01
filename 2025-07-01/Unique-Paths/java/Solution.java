import java.util.*;

class Solution {
    public int uniquePaths ( int m , int n ){
        if( n == 1 && m == 1 ) return 1 ;
        if( n == 0 || m == 0 ) return 0 ;

        int[][] dp = new int[m][n];
        for( int i=m-1 ; i>=0 ; i-- ){
            for( int j=n-1 ; j>=0 ; j-- ){
                if( i == m-1 && j == n-1) continue ;
                if( i == m-1 || j == n-1) dp[i][j] = 1;
                else dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int m1 = 3, n1 = 7;
        System.out.println("Input: m = " + m1 + ", n = " + n1);
        System.out.println("Output: " + new Solution().uniquePaths(m1, n1)); // Expected: 28

        // Test Case 2
        System.out.println("Test Case 2:");
        int m2 = 3, n2 = 2;
        System.out.println("Input: m = " + m2 + ", n = " + n2);
        System.out.println("Output: " + new Solution().uniquePaths(m2, n2)); // Expected: 3

        // Test Case 3
        System.out.println("Test Case 3:");
        int m3 = 1, n3 = 1;
        System.out.println("Input: m = " + m3 + ", n = " + n3);
        System.out.println("Output: " + new Solution().uniquePaths(m3, n3)); // Expected: 1
    }
}
