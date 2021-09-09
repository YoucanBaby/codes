package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-09 00:28
 * @Description:
 */
public class _0313_nthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] index = new int[m];
        Arrays.fill(index, 1);

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, dp[index[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < m; j++) {
                if (dp[index[j]] * primes[j] == dp[i]) {
                    index[j]++;
                }
            }
        }
        return dp[n];
    }
}
