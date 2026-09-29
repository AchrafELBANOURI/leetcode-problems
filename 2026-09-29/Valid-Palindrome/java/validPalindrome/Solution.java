
package validPalindrome;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char cl = s.charAt(left);
            char cr = s.charAt(right);

            if (!((cl >= 'a' && cl <= 'z') || (cl >= 'A' && cl <= 'Z') || (cl >= '0' && cl <= '9'))){ 
                left++; 
                continue; 
            }

            if (!((cr >= 'a' && cr <= 'z') || (cr >= 'A' && cr <= 'Z') || (cr >= '0' && cr <= '9'))){ 
                right--; 
                continue; 
            }

            char lowerCl = (cl >= 'A' && cl <= 'Z') ? (char) (cl + 32) : cl;
            char lowerCr = (cr >= 'A' && cr <= 'Z') ? (char) (cr + 32) : cr;
            if ( lowerCl != lowerCr ) return false;

            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String s_1 = "A man, a plan, a canal: Panama";
        boolean output1 = sol.isPalindrome(s_1);
        boolean expected1 = true;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String s_2 = "race a car";
        boolean output2 = sol.isPalindrome(s_2);
        boolean expected2 = false;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String s_3 = " ";
        boolean output3 = sol.isPalindrome(s_3);
        boolean expected3 = true;

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
