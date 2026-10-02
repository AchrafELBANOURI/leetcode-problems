package twoSumIIInputArrayIsSorted;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0 , right = n-1;
        
        while(left<right){
            
            int sum = numbers[left]+numbers[right];

            if(sum==target){
                return new int[]{left+1,right+1};
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[2];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] numbers_1 = new int[]{2,7,11,15};
        int target_1 = 9;
        int[] output1 = sol.twoSum(numbers_1, target_1);
        int[] expected1 = new int[]{1,2};

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] numbers_2 = new int[]{2,3,4};
        int target_2 = 6;
        int[] output2 = sol.twoSum(numbers_2, target_2);
        int[] expected2 = new int[]{1,3};

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        int[] numbers_3 = new int[]{-1,0};
        int target_3 = -1;
        int[] output3 = sol.twoSum(numbers_3, target_3);
        int[] expected3 = new int[]{1,2};

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
