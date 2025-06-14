import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length ;
        int sum_n = (n*(n+1))/2;
        int sum_nums = 0 ;
        for(int i=0 ; i < n ; i++ ){
            sum_nums += nums[i];
        }
        return sum_n - sum_nums;
    } 
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1: Standard Example
        System.out.println("Test Case 1:");
        int[] nums1 = {3, 0, 1};
        int expected1 = 2;
        int result1 = solution.missingNumber(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Expected: " + expected1 + ", Got: " + result1);
        System.out.println("Result: " + (result1 == expected1 ? "Passed" : "Failed"));
        
        // Test Case 2: Missing Last Number
        System.out.println("\nTest Case 2:");
        int[] nums2 = {0, 1};
        int expected2 = 2;
        int result2 = solution.missingNumber(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Expected: " + expected2 + ", Got: " + result2);
        System.out.println("Result: " + (result2 == expected2 ? "Passed" : "Failed"));
        
        // Test Case 3: Larger Example
        System.out.println("\nTest Case 3:");
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int expected3 = 8;
        int result3 = solution.missingNumber(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Expected: " + expected3 + ", Got: " + result3);
        System.out.println("Result: " + (result3 == expected3 ? "Passed" : "Failed"));
        
        // Test Case 4: Edge Case - Missing Number 1
        System.out.println("\nTest Case 4 (Edge Case):");
        int[] nums4 = {0};
        int expected4 = 1;
        int result4 = solution.missingNumber(nums4);
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Expected: " + expected4 + ", Got: " + result4);
        System.out.println("Result: " + (result4 == expected4 ? "Passed" : "Failed"));
        
        // Test Case 5: Edge Case - Missing Number 0
        System.out.println("\nTest Case 5 (Edge Case):");
        int[] nums5 = {1};
        int expected5 = 0;
        int result5 = solution.missingNumber(nums5);
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Expected: " + expected5 + ", Got: " + result5);
        System.out.println("Result: " + (result5 == expected5 ? "Passed" : "Failed"));
    }
}
