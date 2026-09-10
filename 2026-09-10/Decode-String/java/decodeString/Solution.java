package decodeString;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                
                currentString = new StringBuilder();
                currentNum = 0;
            } else if (c == ']') {
                int repeatCount = countStack.pop();
                StringBuilder prevString = stringStack.pop();
                
                for (int i = 0; i < repeatCount; i++) {
                    prevString.append(currentString);
                }
                currentString = prevString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String s_1 = "3[a]2[bc]";
        String output1 = sol.decodeString(s_1);
        String expected1 = "aaabcbc";

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String s_2 = "3[a2[c]]";
        String output2 = sol.decodeString(s_2);
        String expected2 = "accaccacc";

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String s_3 = "2[abc]3[cd]ef";
        String output3 = sol.decodeString(s_3);
        String expected3 = "abcabccdcdcdef";

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
