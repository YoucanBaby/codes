package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 14:17
 * @Description:
 */
public class AdjMatrix {
    int N;
    int[][] adj;

    public AdjMatrix(int N) {
        this.N = N;				// N是顶点个数
        this.adj = new int[N][N];
    }
}
