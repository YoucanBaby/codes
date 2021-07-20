package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-19 19:43
 * @Description:
 */
public class _0051_solveNQueens {

    List<List<String>> res = new ArrayList<>();
    char[][] chess;         // 棋盘

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        dfs(0);
        return res;
    }

    // row，当前在棋盘的第几行
    public void dfs(int row) {
        // 如果已经递归完最后一行了，就把棋盘转成List，添加到结果中
        if (row == chess.length) {
            res.add(chessToList(chess));
            return;
        }
        // 遍历棋盘的列
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfs(row + 1);           // 递归
                chess[row][col] = '.';      // 回溯
            }
        }
    }

    public boolean valid(char[][] chess, int row, int col) {
        // 判断当前列有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        // 判断右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        // 判断左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // 棋盘转成数组
    public List<String> chessToList(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}
