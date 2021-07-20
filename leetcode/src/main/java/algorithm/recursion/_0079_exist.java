package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 17:05
 * @Description:
 */
public class _0079_exist {

    public boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;

        // 从左上角开始找
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 棋盘，要找的字符串，棋盘下标[i,j]，要找的字符的下标index
    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        // 如果棋盘下标越界，返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        // 如果当前的值不是我们要找的字符
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] = '\0';
        // 递归上下左右，回溯
        boolean res = dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i, j - 1, index + 1) || dfs(board, word, i, j + 1, index + 1);
        board[i][j] = word.charAt(index);
        return res;
    }

}
