package dailyTemperatures;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stackIndices = new int[temperatures.length];
        int[] answer = new int[temperatures.length];
        int top = 0;

        for(int i = temperatures.length-1 ; i >=0 ; i--){
            int dayTemp = temperatures[i];

            while( top > 0 && temperatures[stackIndices[top-1]] <= dayTemp){
                top--;
            }

            if(top > 0){
                answer[i] = stackIndices[top-1] - i;
            }

            stackIndices[top] = i;
            top++;
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] temperatures_1 = new int[]{73,74,75,71,69,72,76,73};
        int[] output1 = sol.dailyTemperatures(temperatures_1);
        int[] expected1 = new int[]{1,1,4,2,1,1,0,0};

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] temperatures_2 = new int[]{30,40,50,60};
        int[] output2 = sol.dailyTemperatures(temperatures_2);
        int[] expected2 = new int[]{1,1,1,0};

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        int[] temperatures_3 = new int[]{30,60,90};
        int[] output3 = sol.dailyTemperatures(temperatures_3);
        int[] expected3 = new int[]{1,1,0};

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
