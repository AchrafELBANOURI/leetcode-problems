import java.util.*;
import utilities.TestUtils;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] input = {3,2,3};
        List<Integer> output = sol.majorityElement(input);
        List<Integer> expected = Arrays.asList(3);

        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
        
        // Test Case 2
        input = new int[]{1};
        output = sol.majorityElement(input);
        expected = Arrays.asList(1);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 2"
        );        
        
        // Test Case 3
        input = new int[]{1,2};
        output = sol.majorityElement(input);
        expected = Arrays.asList(1,2 );
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 3"
        );
    }
}
