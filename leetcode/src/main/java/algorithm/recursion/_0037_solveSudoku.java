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

    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    public boolean dfs(char[][] board) {
        // 遍历行和列, 每次递归都从(0,0)开始遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {       // 当前位置有值了
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {  // 棋盘是否合法
                        board[i][j] = k;
                        if (dfs(board) == true) {
                            return true;            // 如果找到合适的一组就返回
                        }
                        board[i][j] = '.';      // 回溯
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
}
