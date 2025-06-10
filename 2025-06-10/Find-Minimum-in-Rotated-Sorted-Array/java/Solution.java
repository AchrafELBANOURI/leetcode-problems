import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;

        if(length == 1){
            return nums[0];
        }

        int leftMost = 0 , rightMost = length - 1;

        if( nums[rightMost] > nums[0] ){
            return nums[0];
        }

        while (leftMost < rightMost) {
            int medium = (leftMost + rightMost) / 2;

            if (nums[medium] > nums[medium + 1]) return nums[medium + 1];
            if (nums[medium] < nums[medium - 1]) return nums[medium];

            if (nums[medium] > nums[0]) leftMost = medium + 1;
            else rightMost = medium - 1;
        }
        return nums[leftMost];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.findMin(nums1));  // Expected: 1
        
        // Test Case 2
        System.out.println("\nTest Case 2:");
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.findMin(nums2));  // Expected: 0
        
        // Test Case 3
        System.out.println("\nTest Case 3:");
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.findMin(nums3));  // Expected: 11
        
        // Test Case 4 (Edge case with single element)
        System.out.println("\nTest Case 4 (Edge Case):");
        int[] nums4 = {1};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + solution.findMin(nums4));  // Expected: 1
    }
}
