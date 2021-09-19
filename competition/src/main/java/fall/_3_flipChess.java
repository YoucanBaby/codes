package fall;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: fall
 * @Author: xuyifang
 * @CreateTime: 2021-09-11 17:05
 * @Description:
 */
public class _3_flipChess {

    public static void main(String[] args) {
        _3_flipChess solution = new _3_flipChess();

        String[] chessboard = {"....X.","....X.","XOOO..","......","......"};
        System.out.println(solution.flipChess(chessboard));
    }

    int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},     // 第一行
            {0, -1},           {0, 1},      // 第二行
            {1, -1}, {1, 0}, {1, 1}        	// 第三行
    };

    public int flipChess(String[] chessboard) {
        int N = chessboard[0].length();
        int M = chessboard.length;
        char[][] mat = new char[M][N];
        for (int i = 0; i < M; i++) {
            mat[i] = chessboard[i].toCharArray();
//            System.out.println(Arrays.toString(mat[i]));
        }

        int res = 0;
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (mat[x][y] != '.') {
                    res = Math.max(res, getCount(mat, x, y));
                }
            }
        }
        return res;
    }

    private int getCount(char[][] mat, int x, int y) {
        int res = 0;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            int count = 0;
            if (inArea(mat, nextX, nextY) && mat[nextX][nextY] == 'O') {
                count = 1;
                nextX += dir[0];
                nextY += dir[1];
                while (true) {
                    if (!inArea(mat, nextX, nextY)) {
                        break;
                    }
                    if (mat[nextX][nextY] == 'X') {
                        break;
                    }
                    if (mat[nextX][nextY] == '.') {
                        break;
                    }
                    count++;
                    nextX += dir[0];
                    nextY += dir[1];
                }
            }
            res += count;
        }
        return res;
    }

    private boolean inArea(char[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
