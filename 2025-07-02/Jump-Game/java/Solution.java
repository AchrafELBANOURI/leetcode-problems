import java.util.*;

class Solution {
    public boolean jumpGame( int[] nums ){
        int goal = nums.length-1;
        
        for( int i=goal-1 ; i>=0 ; i--){
            if( i + nums[i] >= goal ){
                goal = i;
            }
        }

        return goal == 0 ;
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {2,3,1,1,4};
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + new Solution().jumpGame(nums1)); // Expected: true

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] nums2 = {3,2,1,0,4};
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + new Solution().jumpGame(nums2)); // Expected: false

        // Test Case 3
        System.out.println("Test Case 3:");
        int[] nums3 = {0};
        System.out.println("Input: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + new Solution().jumpGame(nums3)); // Expected: true
    }
}
