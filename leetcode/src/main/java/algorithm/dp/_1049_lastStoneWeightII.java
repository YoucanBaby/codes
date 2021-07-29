package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 12:56
 * @Description:
 */
public class _1049_lastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int bigWeight = sum / 2;
        int[] dp = new int[bigWeight + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = bigWeight; j >= dp[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return (sum - dp[bigWeight]) - dp[bigWeight];
    }
}
