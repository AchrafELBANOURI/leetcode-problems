import java.util.*;

class Solution {
    public int numDecodings( String s ){
        if( s == null || s.isEmpty() || s.charAt(0) == '0' ){
            return 0 ;
        }

        int n = s.length();
        int dp1 = 1 , dp2 = 0 ;

        for(int i=n-1 ; i>=0 ; i--){
            int current = 0;
            if( s.charAt(i) != '0' ){
                current = dp1 ;
                if( i < n-1 ){
                    int twoDigits = Integer.parseInt(s.substring(i, i+2));
                    if( 10 <= twoDigits && twoDigits <= 26 ){
                        current += dp2;
                    }
                }
            }
            dp2 = dp1;
            dp1 = current ; 
        }
        return dp1;
    } 
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test Case 1: Empty string
        System.out.println("Test Case 1:");
        String s1 = "";
        System.out.println(sol.numDecodings(s1)); // Expected: 0

        // Test Case 2: Single digit (valid)
        System.out.println("Test Case 2:");
        String s2 = "2";
        System.out.println(sol.numDecodings(s2)); // Expected: 1

        // Test Case 3: Two digits (valid)
        System.out.println("Test Case 3:");
        String s3 = "12";
        System.out.println(sol.numDecodings(s3)); // Expected: 2

        // Test Case 4: Two digits (invalid)
        System.out.println("Test Case 4:");
        String s4 = "06";
        System.out.println(sol.numDecodings(s4)); // Expected: 0

        // Test Case 5: Longer valid input
        System.out.println("Test Case 5:");
        String s5 = "226";
        System.out.println(sol.numDecodings(s5)); // Expected: 3
    }
}
