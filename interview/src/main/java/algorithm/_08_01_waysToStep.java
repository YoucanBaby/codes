package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 07:44
 * @Description:
 */
public class _08_01_waysToStep {

    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }

        long MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] % MOD) + (dp[i - 2] % MOD) + (dp[i - 3] % MOD);
        }
        int res = (int) (dp[n] % MOD);
        return res;
    }


    public int waysToStep1(int n) {
        if (n <= 2) {
            return n;
        }

        long MOD = 1000000007;
        long dp1 = 1;
        long dp2 = 2;
        long dp3 = 4;

        for (int i = 4; i <= n; i++) {
            long temp = (dp1 + dp2 + dp3) % MOD;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = temp;
        }
        int res = (int) (dp3 % MOD);
        return res;
    }
}
