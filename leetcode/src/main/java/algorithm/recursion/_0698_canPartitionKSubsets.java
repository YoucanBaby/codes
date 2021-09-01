package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 01:11
 * @Description:
 */
public class _0698_canPartitionKSubsets {


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % k != 0 || max > sum / k) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        return dfs(nums, used, k, sum / k, 0, 0);
    }

    private boolean dfs(int[] nums, boolean[] used, int k, int target, int curSum, int start) {
        if (k == 0) {
            return true;
        }
        if (curSum == target) {
            return dfs(nums, used, k - 1, target, 0, 0);
        }

        for (int i = start; i < nums.length; i++) {
            if (!used[i] && curSum + nums[i] <= target) {
                used[i] = true;
                if (dfs(nums, used, k, target, curSum + nums[i], i + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
