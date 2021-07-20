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
    char[][] chess;

    public int totalNQueens(int n) {
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
            res++;
            return;
        }
        
        // 遍历棋盘的列
        for (int col = 0; col < chess.length; col++) {
            if (isValid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfs(row + 1);
                chess[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chess, int row, int col) {
        // 判断当前列是否有没有皇后
        for (int i = row - 1; i >= 0; i--) {
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
}
