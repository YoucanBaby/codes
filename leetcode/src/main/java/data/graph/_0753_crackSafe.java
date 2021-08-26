package data.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 21:23
 * @Description:
 */
public class _0753_crackSafe {

    Set<Integer> visited = new HashSet<>();
    StringBuilder res = new StringBuilder();

    public String crackSafe(int N, int K) {
        int maxVal = (int) Math.pow(10, N - 1);        // ？
        dfs(0, maxVal, K);
        for (int i = 1; i < N; i++) {
            res.append('0');
        }
        return res.toString();
    }

    private void dfs(int val, int maxVal, int K) {
        for (int i = 0; i < K; i++) {
            int nextVal = val * 10 + i;
            if (!visited.contains(nextVal)) {
                visited.add(nextVal);
                dfs(nextVal % maxVal, maxVal, K);
                res.append(i);
            }
        }
    }
}
