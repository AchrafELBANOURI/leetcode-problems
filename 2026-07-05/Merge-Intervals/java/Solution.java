import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        int r = intervals.length;
        List<int[]> result = new ArrayList<>();

        Arrays.sort( intervals, (a, b) -> Integer.compare(a[0], b[0]) );

        int[] mergedInterval = intervals[0];
        
        for(int i = 1 ; i < r ; i++){
            if( mergedInterval[1] < intervals[i][0] ){
                result.add(mergedInterval);
                mergedInterval = intervals[i];
            }else{
                mergedInterval[1] = Math.max( mergedInterval[1] , intervals[i][1] );
            }
        }

        result.add(mergedInterval);
        return result.toArray(new int[result.size()][2]);
    }
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        Solution s = new Solution();
        int[][] intervals = new int[][]{
            {1,3},{2,6},{8,10},{15,18},
        };
        int[][] output = s.merge(intervals);
        System.out.println(Arrays.deepToString(output));

        // Test Case 2
        System.out.println("Test Case 2:");
        intervals = new int[][]{
            {1,4},{4,5},
        };
        output = s.merge(intervals);
        System.out.println(Arrays.deepToString(output));
        
        // Test Case 3
        System.out.println("Test Case 3:");
        intervals = new int[][]{
            {4,7},{1,4},
        };
        output = s.merge(intervals);
        System.out.println(Arrays.deepToString(output));
    }
}
