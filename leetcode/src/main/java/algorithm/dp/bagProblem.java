package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 03:36
 * @Description:
 */
public class bagProblem {

    public int bagProblem(int[] weight, int[] value, int bigWeight) {
        int[][] dp = new int[weight.length][bigWeight + 1];
        // 初始化第一行
        for (int j = weight[0]; j <= bigWeight; j++) {
            dp[0][j] = value[0];
        }
        // 外层遍历物品，内层遍历背包容量
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bigWeight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[weight.length - 1][bigWeight];
    }

    // 01背包
    public int bagProblem1(int[] weight, int[] value, int bigWeight) {
        int[] dp = new int[bigWeight + 1];
        // 外层从左向右遍历物品，内层从右向左遍历背包容量
        for (int i = 0; i < weight.length; i++) {
            for (int j = bigWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bigWeight];
    }

    // 完全背包
    public int bagProblem2(int[] weight, int[] value, int bigWeight) {
        int[] dp = new int[bigWeight + 1];
        // 外层从左向右遍历物品，内层从左向右遍历背包容量
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bigWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bigWeight];
    }

    // 背包问题模板
    public int bagProblem3(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {   // 逆序是01背包，正序是完全背包
                
            }
        }
        return dp[target];
    }
}
