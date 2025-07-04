import java.util.*;

class Solution {
    public int scoreOfString( String s ){
        int l = s.length();
        int score = 0 ;
        for(int i=0; i<l-1 ; i++){
            score += Math.abs( s.charAt(i+1) - s.charAt(i));
        }
        return score ;
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        String s1 = "hello";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + new Solution().scoreOfString(s1)); // Expected: 13

        // Test Case 2
        System.out.println("Test Case 2:");
        String s2 = "zaz";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + new Solution().scoreOfString(s2)); // Expected: 50

        // Test Case 3
        System.out.println("Test Case 3:");
        String s3 = "abc";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + new Solution().scoreOfString(s3)); // Expected: 2
    }
}
