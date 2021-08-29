package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-28 05:53
 * @Description:
 */
public class _0684_findRedundantConnection {


    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UnionFind uf = new UnionFind(N + 1);

        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return edge;
            } else {
                uf.union(edge[0], edge[1]);
            }
        }
        return new int[0];
    }
}
