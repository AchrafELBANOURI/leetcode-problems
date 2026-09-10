package minimumTimeDifference;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;

        boolean[] stockedMinutes = new boolean[1440];
        
        for (String tp : timePoints) {
            int minute = (tp.charAt(0) - '0') * 600
                        + (tp.charAt(1) - '0') * 60
                        + (tp.charAt(3) - '0') * 10
                        + (tp.charAt(4) - '0');
            
            if (stockedMinutes[minute]) {
                return 0;
            }
            stockedMinutes[minute] = true;
        }

        int minDiff = 1440;
        int firstMinute = -1;
        int prevMinute = -1;

        for (int i = 0; i < 1440; i++) {
            if (stockedMinutes[i]) {
                if (firstMinute == -1) {
                    firstMinute = i;
                } else {
                    minDiff = Math.min(minDiff, i - prevMinute);
                }
                prevMinute = i;
            }
        }

        int cornerDiff = (firstMinute + 1440) - prevMinute;
        minDiff = Math.min(minDiff, cornerDiff);

        return minDiff;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        List<String> timePoints_1 = Arrays.asList("23:59","00:00");
        int output1 = sol.findMinDifference(timePoints_1);
        int expected1 = 1;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        List<String> timePoints_2 = Arrays.asList("00:00","23:59","00:00");
        int output2 = sol.findMinDifference(timePoints_2);
        int expected2 = 0;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

    }
}
