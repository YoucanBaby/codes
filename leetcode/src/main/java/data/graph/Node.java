package data.graph;

import java.util.ArrayList;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 16:04
 * @Description:
 */
public class Node {

    int value;
    int in;     // 入度
    int out;    // 出度
    ArrayList<Node> nexts;  // 下一个点
    ArrayList<Edge> edges;

    public Node (int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
