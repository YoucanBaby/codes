package data.graph.uf;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 17:51
 * @Description:
 */
public class _0803_hitBricks {

    public static void main(String[] args) {
        _0803_hitBricks solution = new _0803_hitBricks();
        int[][] mat = {
                {1,0,0,0},
                {1,1,1,0}
        };
        int[][] hits = {{1,0}};

        System.out.println(Arrays.toString(solution.hitBricks(mat, hits)));
    }

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int M = grid.length;
        int N = grid[0].length;

        int[][]mat = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = grid[i][j];
            }
        }
        for (int[] h : hits) {
            mat[h[0]][h[1]] = 0;
        }

        UnionFind uf = new UnionFind(M * N + 1);    // 与屋顶相连的砖块都与M*N相连
        for (int j = 0; j < N; j++) {
            if (mat[0][j] == 1) {
                uf.union(0 * N + j, M * N);     // 连接所有屋顶的砖块
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    if (mat[i - 1][j] == 1) {
                        uf.union((i - 1) * N + j, i * N + j);   // 连接上边的砖块
                    }
                    if (j - 1 >= 0 && mat[i][j - 1] == 1) {
                        uf.union(i * N + j - 1, i * N + j);     // 再连接左边的砖块
                    }
                }
            }
        }

        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                continue;
            }

            int origin = uf.size[uf.find(M * N)];                // 补回之前与屋顶相连的砖头数
            if (x == 0) {
                uf.union(0 * N + y, M * N);     // 如果是屋顶的砖头就与M*N相连
            }

            // 再连接相邻的砖头
            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (inArea(mat, nextX, nextY) && mat[nextX][nextY] == 1) {
                    uf.union(x * N + y, nextX * N + nextY);
                }
            }

            int cur = uf.size[uf.find(M * N)];
            res[i] = Math.max(0, cur - origin - 1);     // 避免cur-origin为0的情况
            mat[x][y] = 1;      // 补上砖头
        }
        return res;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }

    class UnionFind {
        int[] parent;   // 节点i的父节点是parent[i]
        int[] size;

        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;      // 父节点指针初始指向自己
                size[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;          // x成为y的子树
            size[rootY] += size[rootX];
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
