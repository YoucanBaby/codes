package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 17:40
 * @Description:
 */
public class _0198_rob {

    // 空间优化
    public int rob2(int[] nums) {
        int N = nums.length;
        int pre = 0;
        int cur = nums[0];

        for (int i = 2; i <= N; i++) {
            int temp = Math.max(cur, pre + nums[i - 1]);
            pre = cur;
            cur = temp;
        }

        return cur;
    }

    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[N];
    }
}
