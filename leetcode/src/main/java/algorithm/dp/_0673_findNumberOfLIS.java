package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-09-20 14:54
 * @Description:
 */
public class _0673_findNumberOfLIS {


    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int[] count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i]) {
                    if (dp[k] + 1 > dp[i]) {
                        dp[i] = dp[k] + 1;
                        count[i] = count[k];
                    } else if (dp[k] + 1 == dp[i]) {
                        count[i] += count[k];
                    }
                }
            }
        }

        int res = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                res = count[i];
            } else if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}
