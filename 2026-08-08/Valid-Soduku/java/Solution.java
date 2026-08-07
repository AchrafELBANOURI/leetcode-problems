import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();

        // Check rows and columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Check i-th row
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) {
                        return false;
                    }
                    rows.add(board[i][j]);
                }

                // Check i-th column
                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i])) {
                        return false;
                    }
                    cols.add(board[j][i]);
                }
            }
            rows.clear();
            cols.clear();
        }

        // Check 3x3 sub-boxes
        Set<Character> box = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int r = 3 * i; r < 3 * (i + 1); r++) {
                    for (int c = 3 * j; c < 3 * (j + 1); c++) {
                        if (board[r][c] != '.') {
                            if (box.contains(board[r][c])) {
                                return false;
                            }
                            box.add(board[r][c]);
                        }
                    }
                }
                box.clear();
            }
        }

        return true;
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        // Test Case 1
        System.out.println("Test Case 1:");
        char [][] input = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean isValid = s.isValidSudoku(input);
        System.out.println("is Valid ? : " + isValid);
        
        
        // Test Case 2
        System.out.println("Test Case 2:");
        input = new char[][]{
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        isValid = s.isValidSudoku(input);
        System.out.println("is Valid ? : " + isValid);
    }
}
