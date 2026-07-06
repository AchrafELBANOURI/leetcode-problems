import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0 ;
        Arrays.sort(intervals , (a,b) -> Integer.compare( a[0] , b[0] ) );
        int recentEnd = intervals[0][1];

        for( int i = 1 ; i < intervals.length ; i++ ){
            if( intervals[i][0] >= recentEnd ){
                recentEnd = intervals[i][1];
            }else{
                recentEnd = Math.min( recentEnd , intervals[i][1] );
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        Solution s = new Solution();
        int[][] intervals = new int[][]{
            {1,2},{2,3},{3,4},{1,3}
        };
        int output = s.eraseOverlapIntervals(intervals);
        System.out.println(output);
        
        // Test Case 2
        System.out.println("Test Case 2:");
        intervals = new int[][]{
            {1,2},{1,2},{1,2}
        };
        output = s.eraseOverlapIntervals(intervals);
        System.out.println(output);
        
        // Test Case 3
        System.out.println("Test Case 3:");
        intervals = new int[][]{
            {1,2},{2,3}
        };
        output = s.eraseOverlapIntervals(intervals);
        System.out.println(output);
    }
}
