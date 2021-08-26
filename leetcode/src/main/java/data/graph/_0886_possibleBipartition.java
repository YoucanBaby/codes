package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 14:31
 * @Description:
 */
public class _0886_possibleBipartition {

    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;      // -1，蓝色；0，未染色；1，红色

    public boolean possibleBipartition(int N, int[][] dislikes) {
        visited = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            edges.get(dislike[0]).add(dislike[1]);
            edges.get(dislike[1]).add(dislike[0]);
        }

        for (int src = 1; src < N + 1; src++) {
            if (visited[src] == 0) {
                if (dfs(src, 1) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int src, int color) {
        visited[src] = color;
        for (int dst : edges.get(src)) {
            if (visited[dst] == 0) {
                if (dfs(dst, -color) == false) {
                    return false;
                }
            }
            if (visited[src] == visited[dst]) {
                return false;
            }
        }
        return true;
    }
}
