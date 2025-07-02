import java.util.*;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int freq = 1 , result = 0 ;
        
        for(int i=nums.length-2 ; i>=0 ; i--){
            if( nums[i] != nums[i+1] ){
                result += freq;
            }
            freq++;
        }

        return result ;
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {5,1,3};
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + new Solution().reductionOperations(nums1)); // Expected: 3

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] nums2 = {1,1,1};
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + new Solution().reductionOperations(nums2)); // Expected: 0

        // Test Case 3
        System.out.println("Test Case 3:");
        int[] nums3 = {1,1,2,2,3};
        System.out.println("Input: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + new Solution().reductionOperations(nums3)); // Expected: 4
    }
}
