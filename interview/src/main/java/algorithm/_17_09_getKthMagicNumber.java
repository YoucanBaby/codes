package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 08:56
 * @Description:
 */
public class _17_09_getKthMagicNumber {


    public int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int i3 = 1, i5 = 1, i7 = 1;
        for (int i = 2; i <= k; i++) {
            int n3 = dp[i3] * 3;
            int n5 = dp[i5] * 5;
            int n7 = dp[i7] * 7;

            dp[i] = min(n3, n5, n7);

            if (dp[i] == n3) i3++;
            if (dp[i] == n5) i5++;
            if (dp[i] == n7) i7++;
        }
        return dp[k];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
