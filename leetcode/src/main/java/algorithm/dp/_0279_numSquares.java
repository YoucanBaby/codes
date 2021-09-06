package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-31 03:24
 * @Description:
 */
public class _0279_numSquares {

    public int numSquares(int target) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            nums.add(i * i);
        }

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = nums.get(i); j <= target; j++) {
                if (j - nums.get(i) == Integer.MAX_VALUE) {
                    continue;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - nums.get(i)] + 1);
                }
            }
        }
        return dp[target];
    }

    // 优化代码：
    public int numSquares1(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - i * i >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[target];
    }


    public int numSquares2(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = i * i; j <= target; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[target];
    }
}
