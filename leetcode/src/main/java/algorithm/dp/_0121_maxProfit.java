package algorithm.dp;

import java.util.function.Predicate;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 16:49
 * @Description:
 */
public class _0121_maxProfit {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}
