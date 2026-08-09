import utilities.TestUtils;

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] input = {2,2,1,1,1,2,2};
        int output = sol.majorityElement(input);
        int expected = 3;

        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
        
        // Test Case 2
        input = new int[]{2,2,1,1,1,2,2};
        output = sol.majorityElement(input);
        expected = 2;
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 2"
        );
    }
}
