import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic( int[][] heights ){
        int ROWS = heights.length , COLS = heights[0].length ;
        if( COLS == 0 ){
            return new ArrayList<>();
        }

        HashSet<List<Integer>> pac_set = new HashSet<List<Integer>>();
        HashSet<List<Integer>> atl_set = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();

        for( int r=0 ; r<ROWS ; r++){
            dfs( r , 0 , pac_set , heights[r][0] , ROWS , COLS , heights );
            dfs( r , COLS-1 , atl_set , heights[r][COLS-1] , ROWS , COLS , heights );
        }

        for( int c=0 ; c<COLS ; c++){
            dfs( 0 , c , pac_set , heights[0][c] , ROWS , COLS , heights );
            dfs( ROWS-1 , c , atl_set , heights[ROWS-1][c] , ROWS , COLS , heights );
        }

        for(int r=0 ; r<ROWS ; r++){
            for( int c=0 ; c<COLS ; c++){
                List<Integer> coord = Arrays.asList(r,c);
                if( pac_set.contains(coord) && atl_set.contains(coord)){
                    result.add(coord);
                }
            }
        }

        return result ;
    } 

    private void dfs( int r , int c , HashSet<List<Integer>> visitedSet , Integer prevHeight , int ROWS , int COLS , int[][] heights ){
        if( r<0 || c<0 || r==ROWS || c==COLS || heights[r][c] < prevHeight || visitedSet.contains(Arrays.asList(r,c))){
            return ;
        }

        visitedSet.add(Arrays.asList(r,c));
        dfs( r+1 , c , visitedSet , heights[r][c] , ROWS , COLS , heights );
        dfs( r-1 , c , visitedSet , heights[r][c] , ROWS , COLS , heights );
        dfs( r , c+1 , visitedSet , heights[r][c] , ROWS , COLS , heights );
        dfs( r , c-1 , visitedSet , heights[r][c] , ROWS , COLS , heights );
    }
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[][] heights1 = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println("Input: " + Arrays.deepToString(heights1));
        System.out.println("Output: " + new Solution().pacificAtlantic(heights1)); // Expected: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

        // Test Case 2
        System.out.println("Test Case 2:");
        int[][] heights2 = new int[][]{{2,1},{1,2}};
        System.out.println("Input: " + Arrays.deepToString(heights2));
        System.out.println("Output: " + new Solution().pacificAtlantic(heights2)); // Expected: [[0,0],[0,1],[1,0],[1,1]]

        // Test Case 3
        System.out.println("Test Case 3:");
        int[][] heights3 = new int[][]{{1,1},{1,1}};
        System.out.println("Input: " + Arrays.deepToString(heights3));
        System.out.println("Output: " + new Solution().pacificAtlantic(heights3)); // Expected: [[0,0],[0,1],[1,0],[1,1]]
    }
}
