import java.util.*;

class Solution {
    // Dynamic Programming Approach
    // Time Complexity : o(n^2)
    // Space Complexity : o(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int maxLIS = 1;

        Arrays.fill( LIS , 1 );

        for( int i = n-1 ; i >=0 ; i-- ){
            for( int j = i+1 ; j < n ; j++ ){
                if( nums[i] < nums[j] ){
                    LIS[i] = Math.max( LIS[i] , LIS[j] + 1 );
                    maxLIS = Math.max( maxLIS , LIS[i]);
                }
            }
        }   
        
        return maxLIS ;
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums1)); // Expected: 4

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] nums2 = {0,1,0,3,2,3};
        System.out.println(new Solution().lengthOfLIS(nums2)); // Expected: 4

        // Test Case 3
        System.out.println("Test Case 3:");
        int[] nums3 = {7,7,7,7,7,7,7};
        System.out.println(new Solution().lengthOfLIS(nums3)); // Expected: 1

        // Test Case 4
        System.out.println("Test Case 4:");
        int[] nums4 = {1,3,6,7,9,4,10,5,6};
        System.out.println(new Solution().lengthOfLIS(nums4)); // Expected: 6
    }
}
