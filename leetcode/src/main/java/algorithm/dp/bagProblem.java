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
        for (int i = 1; i < weight.length; i++) {
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

    public int bagProblem1(int[] weight, int[] value, int bigWeight) {
        int[] dp = new int[bigWeight + 1];
        // 外层从左向右遍历物品，内层从右向左遍历背包容量
        for (int i = 1; i < weight.length; i++) {
            for (int j = bigWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bigWeight];
    }
}