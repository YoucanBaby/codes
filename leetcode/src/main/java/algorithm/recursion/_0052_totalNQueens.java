package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 09:31
 * @Description:
 */
public class _0052_totalNQueens {

    int res = 0;

    public int totalNQueens(int n) {
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = '.';
            }
        }

        dfs(mat, 0);
        return res;
    }

    public void dfs(char[][] mat, int x) {
        if (x == mat.length) {
            res++;
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
}
