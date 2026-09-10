package asteroidCollision;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = 0;

        for(int ast : asteroids){
            boolean destroyed = false;

            while( top > 0 && stack[top - 1] > 0 && ast < 0 ){
                int topSize = stack[top-1];
                int astSize = Math.abs(ast);
                if( topSize == astSize ){
                    destroyed = true;
                    top--;
                    break;
                } 
                else if( topSize < astSize ){
                    top--;
                }
                else{
                    destroyed = true;
                    break;
                }
            }

            if(!destroyed){
                stack[top] = ast;
                top++;
            }
        }

        int[] result = new int[top];
        System.arraycopy(stack, 0, result, 0, top);
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] asteroids_1 = new int[]{5,10,-5};
        int[] output1 = sol.asteroidCollision(asteroids_1);
        int[] expected1 = new int[]{5,10};

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] asteroids_2 = new int[]{8,-8};
        int[] output2 = sol.asteroidCollision(asteroids_2);
        int[] expected2 = new int[]{};

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        int[] asteroids_3 = new int[]{10,2,-5};
        int[] output3 = sol.asteroidCollision(asteroids_3);
        int[] expected3 = new int[]{10};

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

        // Test Case 4
        int[] asteroids_4 = new int[]{3,5,-6,2,-1,4};
        int[] output4 = sol.asteroidCollision(asteroids_4);
        int[] expected4 = new int[]{-6,2,4};

        TestUtils.assertTest(
            expected4, 
            output4,
            "Test Case 4"
        );

    }
}
