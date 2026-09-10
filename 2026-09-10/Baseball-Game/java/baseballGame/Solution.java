package baseballGame;

import utilities.TestUtils;

class Solution {
    public int calPoints(String[] operations) {
        int[] records = new int[operations.length];
            int currIndex = -1;
            int resultSum = 0;
    
            for(String op : operations){
                switch(op){
                    case "C" :
                        resultSum -= records[currIndex];
                        records[currIndex--] = 0;
                        break;
                    case "D" :
                        records[currIndex+1] = records[currIndex] * 2;
                        resultSum += records[++currIndex];
                        break;
                    case "+" :
                        records[currIndex+1] = records[currIndex] + records[currIndex-1];
                        resultSum += records[++currIndex];
                        break;
                    default :
                        records[currIndex+1] = Integer.parseInt(op);
                        resultSum += records[++currIndex];
                }
            }
    
            return resultSum;
        }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String[] operations_1 = new String[]{"5","2","C","D","+"};
        int output1 = sol.calPoints(operations_1);
        int expected1 = 30;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String[] operations_2 = new String[]{"5","-2","4","C","D","9","+","+"};
        int output2 = sol.calPoints(operations_2);
        int expected2 = 27;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String[] operations_3 = new String[]{"1","C"};
        int output3 = sol.calPoints(operations_3);
        int expected3 = 0;

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
