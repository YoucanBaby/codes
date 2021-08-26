package data.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 14:17
 * @Description:
 */
public class _0310_findMinHeightTrees {


    public List<Integer> findMinHeightTrees(int N, int[][] relations) {
        List<Integer> res = new ArrayList<>();
        if (N == 1) {
            res.add(0);
            return res;
        }

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());       // 初始化所有的点
        }
        int[] degree = new int[N];              // 度
        for (int[] r : relations) {             // 添加节点和度
            edges.get(r[0]).add(r[1]);
            edges.get(r[1]).add(r[0]);
            degree[r[0]]++;
            degree[r[1]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {       // 添加所有度为1的点
            if (degree[i] == 1) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            res.clear();
            int size = deque.size();

            for (int i = 0; i < size; i++) {        // 遍历这一整层
                Integer src = deque.removeFirst();
                res.add(src);

                List<Integer> dstList = edges.get(src);
                for (int dst : dstList) {
                    degree[dst]--;
                    if (degree[dst] == 1) {
                        deque.addLast(dst);
                    }
                }
            }
        }
        return res;
    }
}
