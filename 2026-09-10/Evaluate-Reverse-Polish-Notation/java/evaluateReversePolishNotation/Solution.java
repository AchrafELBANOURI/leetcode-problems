package evaluateReversePolishNotation;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;

        for(String token : tokens){
            switch(token){
                case "+" :
                    stack[top-2] = stack[top-2] + stack[top-1];
                    top--;
                    break;
                case "-" :
                    stack[top-2] = stack[top-2] - stack[top-1];
                    top--;
                    break;
                case "*" :
                    stack[top-2] = stack[top-2] * stack[top-1];
                    top--;
                    break;
                case "/" :
                    stack[top-2] = stack[top-2] / stack[top-1];
                    top--;
                    break;
                default :
                    stack[top++] = Integer.parseInt(token);
            };
        }

        return stack[top-1];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String[] tokens_1 = new String[]{"2","1","+","3","*"};
        int output1 = sol.evalRPN(tokens_1);
        int expected1 = 9;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String[] tokens_2 = new String[]{"4","13","5","/","+"};
        int output2 = sol.evalRPN(tokens_2);
        int expected2 = 6;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String[] tokens_3 = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int output3 = sol.evalRPN(tokens_3);
        int expected3 = 22;

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
