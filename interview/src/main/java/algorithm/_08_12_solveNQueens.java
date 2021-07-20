package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 13:16
 * @Description:
 */
public class _08_12_solveNQueens {

    List<List<String>> res =new ArrayList<>();
    char[][] chess;

    public List<List<String>> solveNQueens(int n) {
        chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        dfs(0);
        return res;
    }

    public void dfs(int row) {
        if (row == chess.length) {
            res.add(new ArrayList<>(chessToList(chess)));
            return;
        }
        // 遍历每一列
        for (int col = 0; col < chess.length; col++) {
            if (isValid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfs(row + 1);
                chess[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chess, int row, int col) {
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

    public List<String> chessToList(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}
