import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < intervals.length ; i++){
            if( newInterval[1] < intervals[i][0] ){
                result.add(newInterval);
                int[][] remaining = Arrays.copyOfRange(intervals, i, intervals.length);
                result.addAll(Arrays.asList(remaining));
                return result.toArray(new int[result.size()][2]);
            }
            else if ( newInterval[0] > intervals[i][1] ){
                result.add(intervals[i]);
            }
            else {
                newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            }
        }

        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        Solution s = new Solution();
        int[][] intervals = new int[][]{
            {1,3},
            {6,9}
        };
        int[] newInterval = new int[]{2,5};
        int[][] output = s.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(output));
        
        // Test Case 2
        System.out.println("Test Case 2:");
        intervals = new int[][]{
            {1,2},
            {3,5},
            {6,7},
            {8,10},
            {12,16}
        };
        newInterval = new int[]{4,8};
        output = s.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(output));
    }
}
