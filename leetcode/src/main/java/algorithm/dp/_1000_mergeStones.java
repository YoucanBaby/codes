package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-05 21:27
 * @Description:
 */
public class _1000_mergeStones {


    public int mergeStones(int[] nums, int k) {
        int N = nums.length;
        if ((N - 1) % (k - 1) != 0) {
            return -1;
        }

        int[] sum = new int[N + 1];                 // 前缀和数组
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int len = k; len <= N; len++) {        // 枚举区间长度
            for (int i = 1; i + len - 1 <= N; i++) {    // 枚举区间左端点
                int j = i + len - 1;                        // 右端点
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = i; p < j; p += k - 1) {        // 枚举区间分界点
                    dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {               // 如果可以继续合并，dp[i][j] += sum(i, j)
                    dp[i][j] += sum[j] - sum[i - 1];
                }
            }
        }
        return dp[1][N];
    }
}
