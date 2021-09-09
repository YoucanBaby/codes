package _0006_二维费用背包;

/**
 * @BelongsProject: codes
 * @BelongsPackage: _0006_二维费用背包
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 22:18
 * @Description:
 */
public class Main {


    public int twoDBag(int[] v, int[] m, int[] w, int V, int M, int N) {
        int[][] dp = new int[V + 1][M + 1];

        for (int i = 0; i < N; i++) {       // 枚举物品
            for (int j = V; j >= v[i]; j--) {   // 逆序枚举体积
                for (int k = M; k >= m[i]; k--) {   // 逆序枚举重量
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - m[i]] + w[i]);
                }
            }
        }
        return dp[V][M];
    }
}
