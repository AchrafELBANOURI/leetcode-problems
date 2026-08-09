package rangeSumQuery2D;
import utilities.TestUtils;

class Solution {
    class NumMatrix {
        private int[][] prefix;
        public NumMatrix(int[][] matrix) {
            computePrefixSum(matrix);
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefix[row2+1][col2+1] - prefix[row1][col2+1] - prefix[row2+1][col1] + prefix[row1][col1];
        }

        private void computePrefixSum(int[][] matrix){
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
                return ;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            prefix = new int[rows+1][cols+1];

            for(int r = 0 ; r < rows ; r++){
                for(int c = 0 ; c < cols ; c++){
                    prefix[r+1][c+1] = prefix[r+1][c] + prefix[r][c+1] - prefix[r][c] + matrix[r][c];
                }
            }
        }
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] inputData = {
            {3,0,1,4,2},
            {5,6,3,2,1},
            {1,2,0,1,5},
            {4,1,0,1,7},
            {1,0,3,0,5}
        };
        NumMatrix numMatrix = sol.new NumMatrix(inputData);

        // Test Case 1
        int[] inputRange = {2,1,4,3};
        int output = numMatrix.sumRegion(inputRange[0],inputRange[1],inputRange[2],inputRange[3]);
        int expected = 8;

        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
        
        // Test Case 2
        inputRange = new int[]{1,1,2,2};
        output = numMatrix.sumRegion(inputRange[0],inputRange[1],inputRange[2],inputRange[3]);
        expected = 11;
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 2"
        );

        // Test Case 3
        inputRange = new int[]{1,2,2,4};
        output = numMatrix.sumRegion(inputRange[0],inputRange[1],inputRange[2],inputRange[3]);
        expected = 12;
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 3"
        );


        // Immutabiliy Test
        int[][] expectedData = {
            {3,0,1,4,2},
            {5,6,3,2,1},
            {1,2,0,1,5},
            {4,1,0,1,7},
            {1,0,3,0,5}
        };

        TestUtils.assertTest(
            expectedData, 
            inputData,
            "Immutability Test"
        );
    }
}
