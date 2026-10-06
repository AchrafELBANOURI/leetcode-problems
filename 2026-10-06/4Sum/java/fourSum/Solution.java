package fourSum;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        if (n == 4) {
            long s = (long) nums[0] + nums[1] + nums[2] + nums[3];
            if (s == target) {
                result.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return result;
        } else if (n < 4) {
            return result;
        }

        for(int i = 0 ; i < n - 3 ; i++ ){
            if( i > 0 && nums[i] == nums[i-1] ) continue;

            long smallest = (long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3];

            long largest = (long) nums[i] + nums[n-1] + nums[n-2] + nums[n-3];

            if(smallest > target) break;
            if(largest < target) continue;

            for(int j = i + 1 ; j < n - 2 ; j++){
                if( j > i + 1 && nums[j] == nums[j-1]) continue;

                long small = (long) nums[i] + nums[j] + nums[j+1] + nums[j+2];

                long large = (long) nums[i] + nums[j] + nums[n-1] + nums[n-2];

                if(small > target) break;
                if(large < target) continue;

                int l = j+1 , r = n-1 ;
                while( l < r ){
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if( sum == target ){
                        result.add(List.of(nums[i],nums[j],nums[l],nums[r]));
                        l++;r--;

                        while( l < r && nums[l] == nums[l-1] ) l++;
                        while( l < r && nums[r] == nums[r+1] ) r--;
                    }
                    else if( sum > target ) r--;
                    else l++;
                }

            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums_1 = new int[]{1,0,-1,0,-2,2};
        int target_1 = 0;
        List<List<Integer>> output1 = sol.fourSum(nums_1, target_1);
        List<List<Integer>> expected1 = List.of(
            List.of(-2,-1,1,2),
            List.of(-2,0,0,2),
            List.of(-1,0,0,1)
        );

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] nums_2 = new int[]{2,2,2,2,2};
        int target_2 = 8;
        List<List<Integer>> output2 = sol.fourSum(nums_2, target_2);
        List<List<Integer>> expected2 = List.of(List.of(2,2,2,2));

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

    }
}
