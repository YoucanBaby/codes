package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 08:09
 * @Description:
 */
public class _0046_translateNum {


    public int translateNum(int n) {
        String ss = String.valueOf(n);
        int N = ss.length();
        ss = ' ' + ss;
        char[] s = ss.toCharArray();

        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            int a = s[i] - '0';
            int b = (s[i - 1] - '0') * 10 + s[i] - '0';
            if (a >= 0 && a <= 9) dp[i] = dp[i - 1];
            if (b >= 10 && b <= 25) dp[i] += dp[i - 2];
        }
        return dp[N];
    }
}
