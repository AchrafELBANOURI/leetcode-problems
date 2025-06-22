import java.util.*;

class Solution {
    public int rob ( int[] nums ) {
        int robNext = 0 ;
        int robNextPlusOne = 0 ;

        for( int i=nums.length-1 ; i>=0 ; i--){
            int current = Math.max( robNext , nums[i] + robNextPlusOne );
            robNextPlusOne = robNext;
            robNext = current ;
        }

        return robNext;
    } 
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test Case 1: Empty list
        System.out.println("Test Case 1:");
        int[] nums1 = {};
        System.out.println(sol.rob(nums1)); // Expected: 0
        
        // Test Case 2: Single house
        System.out.println("Test Case 2:");
        int[] nums2 = {5};
        System.out.println(sol.rob(nums2)); // Expected: 5
        
        // Test Case 3: Two houses
        System.out.println("Test Case 3:");
        int[] nums3 = {2, 3};
        System.out.println(sol.rob(nums3)); // Expected: 3

        // Test Case 4: Example from problem statement
        System.out.println("Test Case 4:");
        int[] nums4 = {1, 2, 3, 1};
        System.out.println(sol.rob(nums4)); // Expected: 4

        // Test Case 5: Second example from problem statement
        System.out.println("Test Case 5:");
        int[] nums5 = {2, 7, 9, 3, 1};
        System.out.println(sol.rob(nums5)); // Expected: 12
    }
}
