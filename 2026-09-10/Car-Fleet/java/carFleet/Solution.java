package carFleet;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // position array has unique values between 0 and target
        float[] time = new float[target+1];

        for(int i = 0 ; i < n ; i++ ){
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }

        int fleets=0;
        float currentTimeFleet=0;
        for(int i = target; i>=0 ; i--){
            float currentTime = time[i];

            if(currentTime > currentTimeFleet){
                fleets++;
                currentTimeFleet = currentTime;
            }
        }

        return fleets;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int target_1 = 12;
        int[] position_1 = new int[]{10,8,0,5,3};
        int[] speed_1 = new int[]{2,4,1,1,3};
        int output1 = sol.carFleet(target_1, position_1, speed_1);
        int expected1 = 3;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int target_2 = 10;
        int[] position_2 = new int[]{3};
        int[] speed_2 = new int[]{3};
        int output2 = sol.carFleet(target_2, position_2, speed_2);
        int expected2 = 1;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        int target_3 = 100;
        int[] position_3 = new int[]{0,2,4};
        int[] speed_3 = new int[]{4,2,1};
        int output3 = sol.carFleet(target_3, position_3, speed_3);
        int expected3 = 1;

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
