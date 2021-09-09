package algorithm.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-31 05:30
 * @Description:
 */
public class _0139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;

        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[N];
    }
}
