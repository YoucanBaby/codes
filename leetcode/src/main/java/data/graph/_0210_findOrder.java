package data.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 04:03
 * @Description:
 */
public class _0210_findOrder {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        if (res.size() != numCourses) {     // 拓扑排序未完成
            return new int[0];
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
