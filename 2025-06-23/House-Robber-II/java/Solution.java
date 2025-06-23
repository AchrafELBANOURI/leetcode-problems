import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int robNext1 = 0 , robNextPlusOne1 = 0;
        int robNext2 = 0 , robNextPlusOne2 = 0;
        int n = nums.length ;
        if( n == 1 ) return nums[0];

        for( int i=1 ; i < n ; i++ ){
            int current1 = Math.max( robNext1 , nums[i] + robNextPlusOne1 );
            robNextPlusOne1 = robNext1;
            robNext1 = current1;

            int current2 = Math.max( robNext2 , nums[n-1-i] + robNextPlusOne2 );
            robNextPlusOne2 = robNext2 ;
            robNext2 = current2;
        }
        return Math.max( robNext1 , robNext2 );
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
        int[] nums4 = {2, 3, 2};
        System.out.println(sol.rob(nums4)); // Expected: 3

        // Test Case 5: Second example from problem statement
        System.out.println("Test Case 5:");
        int[] nums5 = {1, 2, 3, 1};
        System.out.println(sol.rob(nums5)); // Expected: 4
    }
}
