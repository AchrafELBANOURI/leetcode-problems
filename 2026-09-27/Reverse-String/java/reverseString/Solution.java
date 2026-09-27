package reverseString;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i = 0 , j = n-1 ; i < j ; i++ , j-- ){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        char[] s_1 = new char[]{'h','e','l','l','o'};
        sol.reverseString(s_1);
        char[] expected1 = new char[]{'o','l','l','e','h'};

        TestUtils.assertTest(
            expected1, 
            s_1,
            "Test Case 1"
        );

        // Test Case 2
        char[] s_2 = new char[]{'H','a','n','n','a','h'};
        sol.reverseString(s_2);
        char[] expected2 = new char[]{'h','a','n','n','a','H'};

        TestUtils.assertTest(
            expected2, 
            s_2,
            "Test Case 2"
        );

    }
}
