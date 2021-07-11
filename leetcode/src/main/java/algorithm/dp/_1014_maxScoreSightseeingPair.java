package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-11 17:16
 * @Description:
 */
public class _1014_maxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int N = values.length;

        int dp = values[0] + 0;
        int res = values[0] + 0;
        for (int j = 1; j < N; j++) {
            res = Math.max(res, dp + values[j] - j);
            dp = Math.max(dp, values[j] + j);
        }

        return res;
    }
}
