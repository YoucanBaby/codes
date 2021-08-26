package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 20:47
 * @Description:
 */
public class _0332_findItinerary {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> stack = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            map.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }
        dfs("JFK");
        Collections.reverse(stack);
        return stack;
    }

    private void dfs(String src) {
        while (map.containsKey(src) && map.get(src).size() > 0) {
            String dst = map.get(src).remove();
            dfs(dst);
        }
        stack.add(src);
    }
}
