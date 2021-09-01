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

    public List<List<String>> solveNQueens(int n) {
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = '.';            // 初始化棋盘
            }
        }

        dfs(mat, 0);
        return res;
    }

    // x，当前位置在棋盘的第几行
    public void dfs(char[][] mat, int x) {
        if (x == mat.length) {
            res.add(matToList(mat));
            return;
        }

        for (int y = 0; y < mat.length; y++) {
            if (isValid(mat, x, y)) {
                mat[x][y] = 'Q';
                dfs(mat, x + 1);
                mat[x][y] = '.';
            }
        }
    }

    public boolean isValid(char[][] mat, int x, int y) {
        // 判断当前位置上方有没有皇后
        for (int i = x - 1; i >= 0; i--) {
            if (mat[i][y] == 'Q') {
                return false;
            }
        }
        // 判断右上角有没有皇后
        for (int i = x - 1, j = y + 1; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }
        // 判断左上角有没有皇后
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> matToList(char[][] mat) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            path.add(new String(mat[i]));
        }
        return path;
    }
}
