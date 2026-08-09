import utilities.TestUtils;

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if( nums[i] != val ){
                nums[k++] = nums[i];
            }
        }
        
        return k;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] input_data = {3,2,2,3};
        int input_val = 3;
        int output = sol.removeElement(input_data, input_val);
        int expected = 2;

        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
        
        // Test Case 2
        input_data = new int[]{0,1,2,2,3,0,4,2};
        input_val = 2;
        output = sol.removeElement(input_data, input_val);
        expected = 5;
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 2"
        );
    }
}
