package data.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 16:02
 * @Description:
 */
public class Graph {

    HashMap<Integer, Node> nodes;   // 点集
    HashSet<Edge> edges;            // 边集

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
