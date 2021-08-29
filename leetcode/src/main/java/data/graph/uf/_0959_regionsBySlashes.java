package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 01:21
 * @Description:
 */
public class _0959_regionsBySlashes {


    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        UnionFind uf = new UnionFind(4 * N * N);

        for (int i = 0; i < N; i++) {
            char[] arr = grid[i].toCharArray();

            for (int j = 0; j < N; j++) {
                int index = 4 * (i * N + j);    // 二维坐标一维化
                char c = arr[j];
                // 单元格内部合并
                if (c == '/') {
                    uf.union(index, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (c == '\\') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }
                // 单元格外部合并
                if (j + 1 < N) {
                    uf.union(index + 1, 4 * (i * N + j + 1) + 3);
                }
                if (i + 1 < N) {
                    uf.union(index + 2, 4 * ((i + 1) * N + j));
                }
            }
        }
        return uf.count;
    }
}
