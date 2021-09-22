package algorithm.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-21 15:48
 * @Description:
 */
public class _1048_longestStrChain {

    public static void main(String[] args) {
        _1048_longestStrChain solution = new _1048_longestStrChain();

        String[] w = {"a","b","ba","bca","bda","bdca"};
        System.out.println(solution.longestStrChain(w));
    }

    public int longestStrChain(String[] w) {
        Arrays.sort(w, (o1, o2) -> o1.length() - o2.length());
        int N = w.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            for (int k = 0; k < i; k++) {
                if (isChain(w[k], w[i])) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }
        int res = 0;
        for (int d : dp) {
            res = Math.max(res, d);
        }
        return res;
    }

    private boolean isChain(String s, String t) {
        if (s.length() != t.length() - 1) return false;
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i == s.length()) return true;
            if (s.charAt(i) == t.charAt(j)) i++;
        }
        return i == s.length();
    }
}
