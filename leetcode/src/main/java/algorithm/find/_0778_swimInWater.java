package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find.base
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 10:50
 * @Description:
 */
public class _0778_swimInWater {

    boolean[][] visited;

    public int swimInWater(int[][] mat) {
        int N = mat.length;
        visited = new boolean[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, mat[i][j]);
            }
        }
        int left = 0;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mat, mid, 0, 0)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            visited = new boolean[N][N];
        }
        return left;
    }

    private boolean possible(int[][] mat, int mid, int x, int y) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat.length) {       // 越界
            return false;
        }
        if (mat[x][y] > mid) {
            return false;
        }
        if (x == mat.length - 1 && y == mat.length - 1) {
            return true;
        }
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        return  possible(mat, mid, x - 1, y) ||
                possible(mat, mid, x + 1, y) ||
                possible(mat, mid, x, y - 1) ||
                possible(mat, mid, x, y + 1);
    }
}
