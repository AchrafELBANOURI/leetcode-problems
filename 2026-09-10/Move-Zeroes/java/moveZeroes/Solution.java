package moveZeroes;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0 , j = 0 ; i < nums.length ; i++){
            if( nums[i] != 0 ){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums_1 = new int[]{0,1,0,3,12};
        sol.moveZeroes(nums_1);
        int expected1[] = {1,3,12,0,0};

        TestUtils.assertTest(
            expected1, 
            nums_1,
            "Test Case 1"
        );

        // Test Case 2
        int[] nums_2 = new int[]{0};
        sol.moveZeroes(nums_2);
        int[] expected2 = new int[]{0};

        TestUtils.assertTest(
            expected2, 
            nums_2,
            "Test Case 2"
        );

    }
}
