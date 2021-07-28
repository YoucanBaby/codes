package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifan
 * @CreateTime: 2021-07-28 16:33
 * @Description:
 */
public class _0060_dicesProbability {

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        for (int k = 2; k <= n; k++) {
            double[] temp = new double[5 * k + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < 6; j++) {
                    temp[i + j] +=  dp[i] / 6.0;
                }
            }
            dp = temp;
        }

        return dp;
    }
}
