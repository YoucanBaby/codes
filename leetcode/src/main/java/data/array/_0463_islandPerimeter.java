package data.array;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 11:25
 * @Description:
 */
public class _0463_islandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int M = grid.length;
        int N = grid[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    // 上
                    if (i <= 0) {
                        res++;
                    } else if (grid[i - 1][j] == 0) {
                        res++;
                    }
                    // 下
                    if (i >= M - 1) {
                        res++;
                    } else if (grid[i + 1][j] == 0) {
                        res++;
                    }
                    // 左
                    if (j <= 0) {
                        res++;
                    } else if (grid[i][j - 1] == 0) {
                        res++;
                    }
                    // 右
                    if (j >= N - 1) {
                        res++;
                    } else if (grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
