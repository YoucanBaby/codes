package data.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 15:16
 * @Description:
 */
public class _0133_cloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node, cloneNode);

        for (Node n : node.neighbors) {
            cloneNode.neighbors.add(dfs(n, map));
        }
        return cloneNode;
    }
}
