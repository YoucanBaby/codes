package data.graph;

import sun.font.TrueTypeFont;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
        int numCourses = 5;
        int[][] prerequisites = {
                {1,4},
                {2,4},
                {3,1},
                {3,2}
        };
        _0207_canFinish solution = new _0207_canFinish();

        System.out.println(solution.canFinish(numCourses, prerequisites));
    }


    // DFS
    class Solution {
        List<List<Integer>> edges = new ArrayList<>();
        int[] visited;          //  0, 没有访问过; -1, 已被其它节点访问过; 1, 被当前节点访问过

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            visited = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            for (int[] edge : prerequisites) {
                int src = edge[0];
                int dst = edge[1];
                edges.get(src).add(dst);
            }

            for (int src = 0; src < numCourses; src++) {
                if (visited[src] == 0) {
                    if (!dfs(src)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean dfs(int src) {
            visited[src] = 1;
            for (int dst : edges.get(src)) {
                if (visited[dst] == 0) {
                    if (!dfs(dst)) {
                        return false;
                    }
                }
                if (visited[dst] == 1) {
                    return false;
                }
            }
            visited[src] = -1;
            return true;
        }
    }

    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());           // 初始化所有的点
        }

        int[] inDegree = new int[numCourses];       // 入度
        for (int[] p : prerequisites) {             // 添加点和入度
            edges.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        List<Integer> res = new ArrayList<>();      // 拓扑排序的结果
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {      // 添加所有入度为0的点
            if (inDegree[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            Integer src = deque.removeFirst();
            res.add(src);

            List<Integer> dstList = edges.get(src);
            for (int dst : dstList) {
                inDegree[dst]--;
                if (inDegree[dst] == 0) {
                    deque.addLast(dst);
                }
            }
        }
        return res.size() == numCourses;
    }
}
