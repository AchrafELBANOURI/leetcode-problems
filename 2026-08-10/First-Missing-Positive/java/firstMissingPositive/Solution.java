package firstMissingPositive;

import utilities.TestUtils;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for( int i = 0 ; i < n ; i++ ){
            if( nums[i] <= 0 ){
                nums[i] = n+1;
            }
        }

        for( int i = 1 ; i <= n ; i++ ){
            int num = Math.abs(nums[i-1]);
            if( num <= n && nums[num-1] > 0 ){
                nums[num-1] = - nums[num-1];
            }
        }

        for( int i = 1 ; i <= n ; i++ ){
            if(nums[i-1] >= 0){
                return i;
            }
        }

        return n+1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums_1 = {1,2,0};        
        int output1 = sol.firstMissingPositive(nums_1);
        int expected1 = 3;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );
        
        // Test Case 2
        int[] nums_2 = {3,4,-1,1};        
        int output2 = sol.firstMissingPositive(nums_2);
        int expected2 = 2;
        
        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );
        
        // Test Case 3
        int[] nums_3 = {7,8,9,11,12};        
        int output3 = sol.firstMissingPositive(nums_3);
        int expected3 = 1;
        
        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );
    }
}
