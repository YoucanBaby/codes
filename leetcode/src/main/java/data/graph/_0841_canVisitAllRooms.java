package data.graph;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-26 01:46
 * @Description:
 */
public class _0841_canVisitAllRooms {

    boolean[] visited;
    int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);
        return count == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int src) {
        visited[src] = true;
        count++;
        for (int dst : rooms.get(src)) {
            if (!visited[dst]) {
                dfs(rooms, dst);
            }
        }
    }
}
