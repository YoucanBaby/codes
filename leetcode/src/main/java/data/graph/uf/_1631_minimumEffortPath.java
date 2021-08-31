package data.graph.uf;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 04:11
 * @Description:
 */
public class _1631_minimumEffortPath {


    public int minimumEffortPath(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    edges.add(new int[] {
                            Math.abs(mat[i][j + 1] - mat[i][j]),
                            i * N + j,
                            i * N + j + 1
                    });
                }
                if (i + 1 < M) {
                    edges.add(new int[] {
                            Math.abs(mat[i + 1][j] - mat[i][j]),
                            i * N + j,
                            (i + 1) * N + j
                    });
                }
            }
        }
        Collections.sort(edges, (o1, o2) -> o1[0] - o2[0]);

        UnionFind uf = new UnionFind(M * N);
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.find(0) == uf.find(M * N - 1)) {
                return edge[0];
            }
        }
        return 0;
    }
}
