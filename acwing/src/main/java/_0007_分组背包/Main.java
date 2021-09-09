package _0007_分组背包;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: _0007_分组背包
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 23:26
 * @Description:
 */
public class Main {


    public int groupBag(List<List<Integer>> v, List<List<Integer>> w, int V, int N) {
        int[] dp = new int[V + 1];

        for (int i = 0; i < N; i++) {       // 枚举组
            for (int j = V; j >= 0; j--) {      // 枚举容量
                for (int k = 0; k < v.get(i).size(); k++) { // 枚举组号
                    if (j - v.get(i).get(k) >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - v.get(i).get(k)] + w.get(i).get(k));
                    }
                }
            }
        }
        return dp[V];
    }
}
