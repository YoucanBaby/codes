package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 19:49
 * @Description:
 */
public class TopologySort {

    public List<Node> TopologySort(Graph graph) {
        // <节点，节点剩余的入度>
        Map<Node, Integer> map = new HashMap<>();

        // 只有剩余入度为0的点，才进入这个队列
        Deque<Node> zeroInDeque = new ArrayDeque<>();
        for (Node node : graph.nodes.values()) {
            map.put(node, node.in);
            if (node.in == 0) {
                zeroInDeque.add(node);
            }
        }

        List<Node> res = new ArrayList<>();
        while (!zeroInDeque.isEmpty()) {
            Node cur = zeroInDeque.poll();
            res.add(cur);
            for (Node next : cur.nexts) {
                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) {
                    zeroInDeque.add(next);
                }
            }
        }
        return res;
    }
}
