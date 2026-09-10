package validParentheses;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char openBracket = stack.pop();
                if (c == ')' && openBracket != '(') return false;
                if (c == ']' && openBracket != '[') return false;
                if (c == '}' && openBracket != '{') return false;
            }
        }

        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String s_1 = "()";
        boolean output1 = sol.isValid(s_1);
        boolean expected1 = true;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String s_2 = "()[]{}";
        boolean output2 = sol.isValid(s_2);
        boolean expected2 = true;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String s_3 = "(]";
        boolean output3 = sol.isValid(s_3);
        boolean expected3 = false;

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

        // Test Case 4
        String s_4 = "([])";
        boolean output4 = sol.isValid(s_4);
        boolean expected4 = true;

        TestUtils.assertTest(
            expected4, 
            output4,
            "Test Case 4"
        );

        // Test Case 5
        String s_5 = "([)]";
        boolean output5 = sol.isValid(s_5);
        boolean expected5 = false;

        TestUtils.assertTest(
            expected5, 
            output5,
            "Test Case 5"
        );

    }
}
