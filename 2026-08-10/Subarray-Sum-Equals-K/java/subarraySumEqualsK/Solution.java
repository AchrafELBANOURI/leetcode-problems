package subarraySumEqualsK;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0,1);
        
        int prefixSum = 0 ;
        int total = 0 ;
        
        for( int i = 1 ; i <= nums.length ; i++ ){
            prefixSum += nums[i-1];
            
            total += prefixFrequencies.getOrDefault(prefixSum-k,0);
        
            prefixFrequencies.put( prefixSum , prefixFrequencies.getOrDefault(prefixSum,0) + 1 );
        }
        
        return total;
        
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums_1 = new int[]{1,1,1};
        int k_1 = 2;
        int output1 = sol.subarraySum(nums_1, k_1);
        int expected1 = 2;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] nums_2 = new int[]{1,2,3};
        int k_2 = 3;
        int output2 = sol.subarraySum(nums_2, k_2);
        int expected2 = 2;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

    }
}
