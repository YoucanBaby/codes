package odd._250;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._250
 * @Author: xuyifang
 * @CreateTime: 2021-07-18 11:03
 * @Description:
 */
public class _5816_maxGeneticDifference {

    // 暴力超时
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int N = queries.length;
        int[] res = new int[N];
        int node = 0;
        int val = 0;
        int parent = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            node = queries[i][0];
            val = queries[i][1];
            parent = parents[node];
            max = 0;

            while (parent != -1) {
                max = Math.max(max, node ^ val);
                node = parent;
                parent = parents[parent];
            }
            max = Math.max(max, node ^ val);
            res[i] = max;
        }

        return res;
    }
}
