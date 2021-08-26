package data.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-26 02:49
 * @Description:
 */
public class _1136_minimumSemesters {


    public int minimumSemesters(int N, int[][] relations) {
        List<List<Integer>> edges = new ArrayList<>();	// 初始化点
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }
        int[] inDegree = new int[N];            // 入度
        for (int[] r : relations) {             // 添加点和入度
            edges.get(r[0] - 1).add(r[1] - 1);
            inDegree[r[1] - 1]++;
        }

        int count = 0;              // 拓扑排序了几个点
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {           // 添加所有入度为0的点
            if (inDegree[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            res++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int src = deque.removeFirst();
                count++;
                List<Integer> dstList = edges.get(src);
                for (int dst : dstList) {
                    inDegree[dst]--;
                    if (inDegree[dst] == 0) {
                        deque.addLast(dst);
                    }
                }
            }
        }
        return count == N ? res : -1;
    }
}
