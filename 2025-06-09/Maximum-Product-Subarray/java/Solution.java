import java.util.*;

class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = 1;
        int minSoFar = 1;
        int result = nums[0];

        for (int item : nums){
            
            int tmpMax = item * maxSoFar;
            maxSoFar = Math.max(item, Math.max(tmpMax, minSoFar * item));
            minSoFar = Math.min(item, Math.min(tmpMax, minSoFar * item));
            
            result = Math.max(result, maxSoFar);
        }

        return result;
    } 
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + new Solution().maxProduct(nums1)); // Expected: 6

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] nums2 = {-2, 0, -1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + new Solution().maxProduct(nums2)); // Expected: 0
    }
}
