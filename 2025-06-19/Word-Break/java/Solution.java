import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[ s.length() +1 ] ;
        Arrays.fill( dp , false ) ;
        dp[ s.length() ] = true ;

        for( int i = s.length()-1 ; i >= 0 ; i-- ){
            for( String w : wordDict){
                if( i + w.length() <= s.length() && s.substring( i , i+w.length()).equals(w) ){
                    dp[i] = dp[ i + w.length() ];
                }
                if( dp[i] == true ){
                    break ;
                }
            }
        }   
        
        return dp[0];
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(new Solution().wordBreak(s1, wordDict1)); // Expected: true

        // Test Case 2
        System.out.println("Test Case 2:");
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(new Solution().wordBreak(s2, wordDict2)); // Expected: true

        // Test Case 3
        System.out.println("Test Case 3:");
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new Solution().wordBreak(s3, wordDict3)); // Expected: false

        // Test Case 4
        System.out.println("Test Case 4:");
        String s4 = "";
        List<String> wordDict4 = Arrays.asList("a", "b");
        System.out.println(new Solution().wordBreak(s4, wordDict4)); // Expected: true
    }
}
