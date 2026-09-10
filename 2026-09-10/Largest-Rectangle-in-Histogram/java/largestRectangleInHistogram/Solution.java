package largestRectangleInHistogram;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n+1];
        int top = 0 ;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (top > 0 && currentHeight < heights[stack[top-1]]) {
                int height = heights[stack[--top]];
                int width = top == 0 ? i : i - stack[top-1] - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack[top++] = i;
        }

        return maxArea;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] heights_1 = new int[]{2,1,5,6,2,3};
        int output1 = sol.largestRectangleArea(heights_1);
        int expected1 = 10;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] heights_2 = new int[]{2,4};
        int output2 = sol.largestRectangleArea(heights_2);
        int expected2 = 4;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

    }
}
