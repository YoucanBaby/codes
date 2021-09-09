package _0003_完全背包;

/**
 * @BelongsProject: codes
 * @BelongsPackage: _0003_完全背包
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 08:50
 * @Description:
 */
public class Main {

    public int completeBag(int[] v, int[] w, int V, int N) {
        int[] dp = new int[V + 1];

        for (int i = 0; i < N; i++) {
            for (int j = w[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}
