package algorithm.find;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find.base
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 10:50
 * @Description:
 */
public class _0778_swimInWater {

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };
    boolean[][] visited;

    public int swimInWater(int[][] mat) {
        int N = mat.length;
        visited = new boolean[N][N];

        int left = 0;
        int right = (int) 1e6;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mat, mid, 0, 0)) {     // 能到达右下角
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            visited = new boolean[N][N];
        }
        return left;
    }

    private boolean possible(int[][] mat, int mid, int x, int y) {
        if (!inArea(mat, x, y)) return false;
        if (mat[x][y] > mid) return false;
        if (visited[x][y]) return false;

        if (x == mat.length - 1 && y == mat.length - 1) {
            return true;
        }
        visited[x][y] = true;
        boolean res = false;
        for (int[] dir : dirs) {
            res |= possible(mat, mid, x + dir[0], y + dir[1]);
        }
        return res;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
