package data.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-26 02:05
 * @Description:
 */
public class _1042_gardenNoAdj {

    public int[] gardenNoAdj(int N, int[][] paths) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < paths.length; i++) {
            edges.get(paths[i][0] - 1).add(paths[i][1] - 1);
            edges.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }

        int[] res = new int[N];
        for (int src = 0; src < N; src++) {
            Set<Integer> color = new HashSet<Integer>(){{
                add(1);
                add(2);
                add(3);
                add(4);
            }};
            for (int dst : edges.get(src)) {
                color.remove(res[dst]);
            }
            res[src] = color.iterator().next();
        }
        return res;
    }
}
