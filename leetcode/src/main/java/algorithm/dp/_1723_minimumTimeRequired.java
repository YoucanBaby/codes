package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-11 19:10
 * @Description:
 */
public class _1723_minimumTimeRequired {


    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == (1 << j)) {
                    sum[i] = sum[i - (1 << j)] + jobs[j];
                    break;
                }
            }
        }

        int[][] dp = new int[k][1 << n];
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = sum[i];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                int min = Integer.MAX_VALUE;
                for (int s = j; s > 0; s = (s - 1) & j) {
                    int val = Math.max(dp[i - 1][j - s], sum[s]);
                    min = Math.min(min, val);
                }
                dp[i][j] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
}
