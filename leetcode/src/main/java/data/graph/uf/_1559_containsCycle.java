package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 02:33
 * @Description:
 */
public class _1559_containsCycle {


    public boolean containsCycle(char[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        UnionFind uf = new UnionFind(M * N);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 向右搜索
                if (j + 1 < N && mat[i][j] == mat[i][j + 1]) {
                    if (uf.find(i * N + j) == uf.find(i * N + j + 1)) {
                        return true;
                    }
                    uf.union(i * N + j, i * N + j + 1);
                }
                // 向下搜索
                if (i + 1 < M && mat[i][j] == mat[i + 1][j]) {
                    if (uf.find(i * N + j) == uf.find((i + 1)* N + j)) {
                        return true;
                    }
                    uf.union(i * N + j, (i + 1)* N + j);
                }
            }
        }
        return false;
    }
}
