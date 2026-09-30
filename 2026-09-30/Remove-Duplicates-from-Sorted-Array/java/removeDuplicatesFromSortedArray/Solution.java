package removeDuplicatesFromSortedArray;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0 ;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[k] != nums[i]){
               nums[++k] = nums[i];
            }
        }

        return k+1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums_1 = new int[]{1,1,2};
        int output1 = sol.removeDuplicates(nums_1);
        int expected1 = 2;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] nums_2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int output2 = sol.removeDuplicates(nums_2);
        int expected2 = 5;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

    }
}
