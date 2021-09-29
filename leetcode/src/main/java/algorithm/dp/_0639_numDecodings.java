package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-27 02:11
 * @Description:
 */
public class _0639_numDecodings {


    public static void main(String[] args) {
        _0639_numDecodings solution = new _0639_numDecodings();

        String s = "*1";
        System.out.println(solution.numDecodings(s));
    }

    public int numDecodings(String ss) {
        int MOD = (int) (1e9 + 7);
        ss = " " + ss;
        char[] s = ss.toCharArray();
        int N = s.length;
        long[] dp = new long[N];
        dp[0] = 1;
        if (s[1] == '*') dp[1] = 9;
        if (s[1] >= '1' && s[1] <= '9') dp[1] = 1;
        for (int i = 2; i < N; i++) {
            if (s[i] == '*') {
                dp[i] += dp[i - 1] * 9;
                if (s[i - 1] == '1') dp[i] += dp[i - 2] * 9;
                if (s[i - 1] == '2') dp[i] += dp[i - 2] * 6;
                if (s[i - 1] == '*') dp[i] += dp[i - 2] * 15;
            } else {
                if (s[i] != '0') dp[i] += dp[i - 1];
                if (s[i - 1] == '1') dp[i] += dp[i - 2];
                if (s[i - 1] == '2' && s[i] >= '0' && s[i] <= '6') dp[i] += dp[i - 2];
                if (s[i - 1] == '*') {
                    if (s[i] >= '0' && s[i] <= '6') dp[i] += dp[i - 2] * 2;
                    if (s[i] >= '7' && s[i] <= '9') dp[i] += dp[i - 2];
                }
            }
            dp[i] %= MOD;
        }
        return (int) dp[N - 1];
    }
}
