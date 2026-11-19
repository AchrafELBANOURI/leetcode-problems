package trappingRainWater;

import utilities.TestUtils;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0 , right = n-1;

        int leftMax = 0 , rightMax = 0 ;
        int totalWater = 0;
        while( left < right ){
            if( height[left] < height[right] ){
                if( leftMax > height[left] ){
                    totalWater += leftMax - height[left];
                }
                else {
                    leftMax = height[left];
                }
                left++;
            }
            else {
                if( rightMax > height[right] ){
                    totalWater += rightMax - height[right];
                }
                else {
                    rightMax = height[right];
                }
                right--;   
            }
        }
        return totalWater;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] height_1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int output1 = sol.trap(height_1);
        int expected1 = 6;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] height_2 = new int[]{4,2,0,3,2,5};
        int output2 = sol.trap(height_2);
        int expected2 = 9;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

    }
}
