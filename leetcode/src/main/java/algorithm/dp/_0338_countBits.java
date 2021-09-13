package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 07:18
 * @Description:
 */
public class _0338_countBits {


    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public int[] countBits1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 1) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i / 2];
        }
        return dp;
    }
}
