package algorithm.dp;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-31 05:30
 * @Description:
 */
public class _0139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int target = s.length();
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i <= target - 1; i++) {
            for (int j = i + 1; j <= target; j++) {
                String str = s.substring(i, j);
                if (dp[i] == true && wordDict.contains(str)) {
                    dp[j] = true;
                }
            }
        }
        return dp[target];
    }
}
