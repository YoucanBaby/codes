package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-09 10:51
 * @Description:
 */
public class _0264_nthUglyNumber {


    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int i2 = 1;
        int i3 = 1;
        int i5 = 1;

        for (int i = 2; i <= n; i++) {
            int n2 = dp[i2] * 2;
            int n3 = dp[i3] * 3;
            int n5 = dp[i5] * 5;

            dp[i] = min(n2, n3, n5);

            if (n2 == dp[i]) i2++;
            if (n3 == dp[i]) i3++;
            if (n5 == dp[i]) i5++;
        }
        return dp[n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
