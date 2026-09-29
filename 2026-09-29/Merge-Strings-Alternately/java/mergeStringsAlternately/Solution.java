package mergeStringsAlternately;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public String mergeAlternately(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        char[] res = new char[n1+n2];
        int p1 = 0 , p2 = 0 ;
        int k = 0 ;

        while( p1 < n1 && p2 < n2 ){
            if( p1 > p2 ){
                res[k++] += word2.charAt(p2++);
            }
            else if( p1 == p2 ){
                res[k++] += word1.charAt(p1++);
            }
        }

        while( p1 < n1 ){
            res[k++] += word1.charAt(p1++);
        }
        
        while( p2 < n2 ){
            res[k++] += word2.charAt(p2++);
        }

        return String.valueOf(res);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String word1_1 = "abc";
        String word2_1 = "pqr";
        String output1 = sol.mergeAlternately(word1_1, word2_1);
        String expected1 = "apbqcr";

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String word1_2 = "ab";
        String word2_2 = "pqrs";
        String output2 = sol.mergeAlternately(word1_2, word2_2);
        String expected2 = "apbqrs";

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String word1_3 = "abcd";
        String word2_3 = "pq";
        String output3 = sol.mergeAlternately(word1_3, word2_3);
        String expected3 = "apbqcd";

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
