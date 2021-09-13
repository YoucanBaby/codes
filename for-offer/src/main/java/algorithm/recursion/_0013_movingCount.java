package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-29 19:52
 * @Description:
 */
public class _0013_movingCount {

    int M, N, k;
    boolean[][] visited;

    public int movingCount(int M, int N, int k) {
        this.M = M;
        this.N = N;
        this.k = k;
        this.visited = new boolean[M][N];

        return dfs(0,0,0,0);
    }

    public int dfs(int x, int y, int sumX, int sumY) {
        // 如果越界、位数和大于k、已经访问过这个节点了，就返回
        if (x >= M || y >= N || k < sumX + sumY || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        // 递归下方和右方
        int a = dfs(x + 1, y, sum(x + 1), sumY);
        int b = dfs(x, y + 1, sumX, sum(y + 1));
        return 1 + a + b;
    }

    // 求数位之和
    public int sum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
