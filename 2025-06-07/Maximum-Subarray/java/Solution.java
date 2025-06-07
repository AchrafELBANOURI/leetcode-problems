import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int globalSum = nums[0];
        int n = nums.length;
        for(int i = 1; i<n ; i++){
            currentSum = Math.max( currentSum + nums[i] , nums[i]);
            globalSum = Math.max( currentSum , globalSum ) ;
        }
        return globalSum;
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution s = new Solution();
        int result1 = s.maxSubArray(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);  // Expected: 6

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] nums2 = {1};
        int result2 = s.maxSubArray(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);  // Expected: 1

        // Test Case 3
        System.out.println("Test Case 3:");
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = s.maxSubArray(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + result3);  // Expected: 23
    }
}
