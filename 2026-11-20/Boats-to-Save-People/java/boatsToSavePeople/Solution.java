package boatsToSavePeople;

import utilities.TestUtils;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] freqWeight = new int[limit+1];
        int boats = 0;

        for( int p : people ){
            freqWeight[p] += 1;
        }

        int l=0 , r=limit;
        while( l <= r ){
            if( freqWeight[l] == 0 ){
                l++;
                continue;
            }
            if( freqWeight[r] == 0 ){
                r--;
                continue;
            }
            if( l + r > limit ){
                boats += freqWeight[r];
                freqWeight[r]=0;
            }
            else{
                int mini = freqWeight[l] > freqWeight[r] ? 
                                                            freqWeight[r] 
                                                            : 
                                                            freqWeight[l];
                if( l == r ){
                    boats += mini/2 + mini % 2;
                    break;
                }
                boats += mini ;
                freqWeight[l] -= mini;
                freqWeight[r] -= mini;
            }
        }

        return boats;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] people_1 = new int[]{1,2};
        int limit_1 = 3;
        int output1 = sol.numRescueBoats(people_1, limit_1);
        int expected1 = 1;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        int[] people_2 = new int[]{3,2,2,1};
        int limit_2 = 3;
        int output2 = sol.numRescueBoats(people_2, limit_2);
        int expected2 = 3;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        int[] people_3 = new int[]{3,5,3,4};
        int limit_3 = 5;
        int output3 = sol.numRescueBoats(people_3, limit_3);
        int expected3 = 4;

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

    }
}
