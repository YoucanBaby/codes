package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-28 07:28
 * @Description:
 */
public class _1319_makeConnected {


    public int makeConnected(int N, int[][] connections) {
        if (connections.length < N - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(N);
        for (int[] c : connections) {
            uf.union(c[0], c[1]);
        }
        return uf.count - 1;
    }
}
