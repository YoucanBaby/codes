package data.graph.uf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 16:28
 * @Description:
 */
public class _1202_smallestStringWithSwaps {


    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> p : pairs) {
            uf.union(p.get(0), p.get(1));
        }

        Map<Integer, PriorityQueue<Character>> rootAndPQ = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            rootAndPQ.computeIfAbsent(root, key -> new PriorityQueue<>()).add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            sb.append(rootAndPQ.get(root).remove());
        }
        return sb.toString();
    }
}
