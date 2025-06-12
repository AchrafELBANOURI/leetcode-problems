import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length ;

        for( int i = 0 ; i < n ; i++ ){
            if(nums[i] > 0) break ;
            if( i >= 1 && nums[i] == nums[i-1]) continue;

            int l = i + 1 , r = n -1 ;
            while( l < r ){
                int three_sum = nums[i] + nums[l] + nums[r];
                if(three_sum > 0){
                    r--;
                }
                else if( three_sum < 0 ){
                    l++;
                }
                else{
                    output.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    while( l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                }
            }
        }
        return output;
    } 
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.threeSum(nums1));  // Expected: [[-1, -1, 2], [-1, 0, 1]]
        
        // Test Case 2
        System.out.println("\nTest Case 2:");
        int[] nums2 = {0, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.threeSum(nums2));  // Expected: []
        
        // Test Case 3
        System.out.println("\nTest Case 3:");
        int[] nums3 = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.threeSum(nums3));  // Expected: [[0, 0, 0]]
    }
}
