package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-29 19:52
 * @Description:
 */
public class _0013_movingCount {

    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];

        return dfs(0,0,0,0);
    }

    public int dfs(int i, int j, int sumI, int sumJ) {
        // 如果越界、位数和大于k、已经访问过这个节点了，就返回
        if (i >= m || j >= n || k < sumI + sumJ || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        // 递归下方和右方
        int a = dfs(i + 1, j, sum(i + 1), sumJ);
        int b = dfs(i, j + 1, sumI, sum(j + 1));
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
