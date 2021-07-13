package data.graph.base;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 16:04
 * @Description:
 */
public class Edge {

    int weight;     // 权重
    Node from;      // 一个点出
    Node to;        // 另一个点入

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
