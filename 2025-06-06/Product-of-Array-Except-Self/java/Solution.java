import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prec = 1 ; 
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for(int i = 0 ; i < nums.length ; i++){
            result[i] = prec;
            prec *= nums[i];
        }
        prec = 1;
        for(int i = nums.length - 1; i>=0  ;i--){
            result[i] *= prec;
            prec *= nums[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {1, 2, 3, 4};
        Solution s = new Solution();
        int[] result1 = s.productExceptSelf(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1));

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = s.productExceptSelf(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));

        // Test Case 3
        System.out.println("Test Case 3:");
        int[] nums3 = {2, 3, 4, 5};
        int[] result3 = s.productExceptSelf(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
