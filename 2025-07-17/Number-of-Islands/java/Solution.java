import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length , COLS = grid[0].length;
        int num_isl = 0 ;
        HashSet<List<Integer>> visitedSet = new HashSet<List<Integer>>();

        for(int r=0 ; r<ROWS ; r++){
            for(int c=0 ; c<COLS ; c++){
                if( visitedSet.contains(Arrays.asList(r,c)) || grid[r][c] == '0' ){
                    continue ;
                }

                num_isl++ ;
                dfs( r , c , visitedSet , grid , ROWS , COLS );
            }
        }

        return num_isl ; 
    }

    private void dfs( int r , int c , HashSet<List<Integer>> visitedSet , char[][] grid , int ROWS , int COLS ){
        if(visitedSet.contains(Arrays.asList(r,c)) || r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == '0'){
            return ;
        }

        visitedSet.add( Arrays.asList(r,c) );
        dfs( r+1 , c , visitedSet , grid , ROWS , COLS);
        dfs( r , c+1 , visitedSet , grid , ROWS , COLS);
        dfs( r-1 , c , visitedSet , grid , ROWS , COLS);
        dfs( r , c-1 , visitedSet , grid , ROWS , COLS);
    } 
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        char[][] grid1 = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        };
        System.out.println(new Solution().numIslands(grid1)); // Expected: 1

        // Test Case 2
        System.out.println("Test Case 2:");
        char[][] grid2 = {
            {'1', '0', '1'},
            {'0', '0', '0'},
            {'1', '0', '1'}
        };
        System.out.println(new Solution().numIslands(grid2)); // Expected: 4

        // Test Case 3
        System.out.println("Test Case 3:");
        char[][] grid3 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(new Solution().numIslands(grid3)); // Expected: 3
    }
}
