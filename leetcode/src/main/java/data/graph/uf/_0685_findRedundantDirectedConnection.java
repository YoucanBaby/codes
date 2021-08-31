package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 16:46
 * @Description:
 */
public class _0685_findRedundantDirectedConnection {


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;           // 边的条数，在本题等于节点数量
        int[] inDegree = new int[N + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                if (!isCircle(edges, i)) {
                    return edges[i];        // 不成环，这条边就是需要去掉的边
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                if (!isCircle(edges, i)) {
                    return edges[i];        // 不成环，这条边就是需要去掉的边
                }
            }
        }
        return new int[0];
    }

    private boolean isCircle(int[][] edges, int removeEdgeIndex) {
        int N = edges.length;
        UnionFind uf = new UnionFind(N + 1);
        for (int i = 0; i < N; i++) {
            if (i == removeEdgeIndex) {
                continue;
            }
            if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
                return true;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return false;
    }
}
