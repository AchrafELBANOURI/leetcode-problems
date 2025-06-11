import java.util.*;

class Solution {
    public int search( int[] nums , int target ){
        int l = 0 , r = nums.length - 1 ;
        
        while( l <= r ){
            int m = ( l + r ) / 2;

            if( nums[m] == target ) return m;

            if( nums[m] >= nums[l] ){
                if( nums[l] <= target && target < nums[m] ) r = m - 1;
                else l = m + 1;
            }
            else{
                if( nums[m] < target && target <= nums[r] ) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    } 
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + solution.search(nums1, target1));  // Expected: 4
        
        // Test Case 2
        System.out.println("\nTest Case 2:");
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + solution.search(nums2, target2));  // Expected: -1
        
        // Test Case 3
        System.out.println("\nTest Case 3:");
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + solution.search(nums3, target3));  // Expected: -1
        
        // Test Case 4
        System.out.println("\nTest Case 4:");
        int[] nums4 = {1};
        int target4 = 1;
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + solution.search(nums4, target4));  // Expected: 0
    }
}
