package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 22:27
 * @Description:
 */
public class _0130_solve {

    char[][] board;
    int M;
    int N;

    public void solve(char[][] board) {
        this.board = board;
        M = board.length;
        N = board[0].length;

        // 遍历第0列和最后一列
        for (int i = 0; i < M; i++) {
            dfs(i, 0);
            dfs(i, N - 1);
        }

        // 遍历第0行和最后一行
        for (int j = 0; j < N; j++) {
            dfs(0, j);
            dfs(M - 1, j);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j) {
        if (i < 0 || i >= M) {
            return;
        }
        if (j < 0 || j >= N) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }else {
            board[i][j] = 'B';
            // 上下左右
            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j - 1);
            dfs(i, j + 1);
        }
    }
}
