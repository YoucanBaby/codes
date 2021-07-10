package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 13:51
 * @Description:
 */
public class _0529_updateBoard {

    // 八连通
    int[][] dirs = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1},
    };
    int M;
    int N;
    char[][] board;

    public char[][] updateBoard(char[][] board, int[] click) {
        M = board.length;
        N = board[0].length;
        this.board = board;
        int i = click[0];
        int j = click[1];

        dfs(i, j);
        return board;
    }

    public void dfs(int i, int j) {
        // 如果当前位置是已经爆炸的雷，直接返回
        if (board[i][j] == 'X') {
            return;
        }
        // 如果当前位置是颗未爆炸的雷，则引爆，返回
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        // 统计board[i][j]周围的地雷数量
        int count = 0;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < M && nextJ >= 0 && nextJ < N) {
                if (board[nextI][nextJ] == 'M') {
                    count++;
                }
            }
        }

        // 如果有地雷，返回地雷数量
        if (count > 0) {
            board[i][j] = (char) (count + '0');
            return;
        } else {
            // 否则，对八个方向的空位置做DFS
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI >= 0 && nextI < M && nextJ >= 0 && nextJ < N) {
                    if (board[nextI][nextJ] == 'E') {
                        dfs(nextI, nextJ);
                    }
                }
            }
        }
    }
}
