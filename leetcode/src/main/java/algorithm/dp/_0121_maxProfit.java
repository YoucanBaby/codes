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
        int minPrice = prices[0];
        int res = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (res < price - minPrice) {
                res = price - minPrice;
            }
        }
        return res;
    }
}
