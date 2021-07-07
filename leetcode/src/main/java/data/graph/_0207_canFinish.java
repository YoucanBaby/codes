package data.graph;

import sun.font.TrueTypeFont;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 19:19
 * @Description:
 */
public class _0207_canFinish {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1,0},
                {0,1}
        };
        _0207_canFinish solution = new _0207_canFinish();

        System.out.println(solution.canFinish(numCourses, prerequisites));
    }


    int[] visited;          // 是否访问过, 0, 没有访问过; -1, 已被其它节点访问过; 1, 被当前节点访问过
    List<List<Integer>> edges = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        // 初始化边
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 添加边
        for (int[] edge : prerequisites) {
            int src = edge[0];
            int dst = edge[1];
            edges.get(src).add(dst);
        }
        // dfs
        for (int src = 0; src < numCourses; src++) {
            if (!dfs(src)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int src) {
        if (visited[src] == -1) {
            return true;
        }
        if (visited[src] == 1) {
            return false;
        }

        visited[src] = 1;
        for (int dst : edges.get(src)) {
            if (!dfs(dst)) {
                return false;
            }
        }
        visited[src] = -1;

        return true;
    }
}
