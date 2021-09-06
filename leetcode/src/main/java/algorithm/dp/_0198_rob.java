package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 17:40
 * @Description:
 */
public class _0198_rob {

    public int rob2(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }

        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);

        for (int i = 2; i < N; i++) {
            int tempCur = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = tempCur;
        }
        return cur;
    }

    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }

        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[N - 1];
    }
}
