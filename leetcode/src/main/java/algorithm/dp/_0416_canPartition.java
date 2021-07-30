package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 05:36
 * @Description:
 */
public class _0416_canPartition {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        _0416_canPartition solution = new _0416_canPartition();

        System.out.println(solution.canPartition1(nums));
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // sum是奇数，返回false
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;    // 是否找到总和为(sum/2)的值
    }
}
