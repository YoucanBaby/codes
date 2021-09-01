package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 17:05
 * @Description:
 */
public class _0079_exist {

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public boolean exist(char[][] mat, String word) {
        int M = mat.length;
        int N = mat[0].length;

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (dfs(mat, word, x, y, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (board[x][y] == word.charAt(index)) {
            board[x][y] = '#';
            for (int[] dir : dirs) {
                if (dfs(board, word, x + dir[0], y + dir[1], index + 1)) {
                    return true;
                }
            }
            board[x][y] = word.charAt(index);
        }
        return false;
    }
}
