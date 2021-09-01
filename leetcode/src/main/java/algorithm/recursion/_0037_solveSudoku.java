package algorithm.recursion;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 10:02
 * @Description:
 */
public class _0037_solveSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','.','.','.','.','.'},
                {'2','1','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','3','.','.','.','.','.','.','.'}
        };
        _0037_solveSudoku solution = new _0037_solveSudoku();
        solution.solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void solveSudoku(char[][] mat) {
        dfs(mat);
    }

    public boolean dfs(char[][] mat) {
        // 遍历行和列, 每次递归都从(0,0)开始遍历
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != '.') {       // 当前位置有值了
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(mat, i, j, k)) {  // 棋盘是否合法
                        mat[i][j] = k;
                        if (dfs(mat) == true) {
                            return true;            // 如果找到合适的一组就返回
                        }
                        mat[i][j] = '.';      // 回溯
                    }
                }
                return false;   // 如果试遍了1~9，都没有找到，就返回false
            }
        }
        return true;    // 找到适合的一组棋盘
    }

    public boolean isValid(char[][] board, int row, int col, char k) {
        // 判断这一行是否重复
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == k) {
                return false;
            }
        }
        // 判断这一列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }
        // 判断九方格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    class Solution {
        public void solveSudoku(char[][] mat) {
            dfs(mat);
        }

        public boolean dfs(char[][] mat) {
            for (int x = 0; x < mat.length; x++) {
                for (int y = 0; y < mat[0].length; y++) {
                    if (mat[x][y] != '.') {
                        continue;
                    }
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(mat, x, y, k)) {
                            mat[x][y] = k;
                            if (dfs(mat)) {
                                return true;
                            }
                            mat[x][y] = '.';
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean isValid(char[][] mat, int x, int y, char k) {
            for (int j = 0; j < mat[0].length; j++) {   // 判断这一行是否重复
                if (mat[x][j] == k) {
                    return false;
                }
            }
            for (int i = 0; i < mat.length; i++) {      // 判断这一列是否重复
                if (mat[i][y] == k) {
                    return false;
                }
            }
            // 判断九方格里是否重复
            int startX = (x / 3) * 3;
            int startY = (y / 3) * 3;
            for (int i = startX; i < startX + 3; i++) {
                for (int j = startY; j < startY + 3; j++) {
                    if (mat[i][j] == k) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
