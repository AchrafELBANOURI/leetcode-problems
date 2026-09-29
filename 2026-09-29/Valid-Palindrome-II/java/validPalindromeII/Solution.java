package validPalindromeII;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();

        for(int left = 0 , right = n-1 ; left < right ; left++ , right--){
            if( s.charAt(left) != s.charAt(right) ){
                return isPalindromRange(s , left+1 , right) || isPalindromRange(s , left , right-1);
            }
        }

        return true;
    }

    private boolean isPalindromRange( String s , int left , int right ){
        for(int i = left , j = right ; i < j ; i++ , j--){
            if( s.charAt(i) != s.charAt(j) ) return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String s_1 = "aba";
        boolean output1 = sol.validPalindrome(s_1);
        boolean expected1 = true;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String s_2 = "abca";
        boolean output2 = sol.validPalindrome(s_2);
        boolean expected2 = true;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String s_3 = "abc";
        boolean output3 = sol.validPalindrome(s_3);
        boolean expected3 = false;

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
