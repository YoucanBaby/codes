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
        int pre = values[0] + 0;
        int res = values[0] + 0;

        for (int j = 1; j < values.length; j++) {
            res = Math.max(res, pre + values[j] - j);
            pre = Math.max(pre, values[j] + j);
        }
        return res;
    }
}
