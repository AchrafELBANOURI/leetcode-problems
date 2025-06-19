import java.util.*;

class Solution {
    public int longestCommonSubsequence( String text1 , String text2 ){
        int n1 = text1.length() ;
        int n2 = text2.length() ; 

        int[][] dp = new int[n1+1][n2+1];

        for(int i = n1-1 ; i >= 0 ; i-- ){
            for(int j = n2-1 ; j >= 0 ; j-- ){
                if( text1.charAt(i) == text2.charAt(j) ) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max( dp[i+1][j] , dp[i][j+1] );
                }
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        String text1_1 = "abcde";
        String text2_1 = "ace";
        System.out.println(new Solution().longestCommonSubsequence(text1_1, text2_1)); // Expected: 3

        // Test Case 2
        System.out.println("Test Case 2:");
        String text1_2 = "abc";
        String text2_2 = "abc";
        System.out.println(new Solution().longestCommonSubsequence(text1_2, text2_2)); // Expected: 3

        // Test Case 3
        System.out.println("Test Case 3:");
        String text1_3 = "abc";
        String text2_3 = "def";
        System.out.println(new Solution().longestCommonSubsequence(text1_3, text2_3)); // Expected: 0

        // Test Case 4
        System.out.println("Test Case 4:");
        String text1_4 = "abcde";
        String text2_4 = "";
        System.out.println(new Solution().longestCommonSubsequence(text1_4, text2_4)); // Expected: 0
    }
}
