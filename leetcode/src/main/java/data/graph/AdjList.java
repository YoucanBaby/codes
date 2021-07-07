package data.graph;

import java.util.ArrayList;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 14:30
 * @Description:
 */
public class AdjList {
    int N;
    ArrayList<Integer>[] adj;

    public AdjList(int N) {
        this.N = N;         // N是顶点的个数
        adj = new ArrayList[N];
    }
}
