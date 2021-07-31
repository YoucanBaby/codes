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
        if (nums.length == 1) {
            return nums[0];
        }
        int N = nums.length;
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);

        for (int i = 2; i < N; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int N = nums.length;
        int[] dp = new int[N];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[N -1];
    }
}
