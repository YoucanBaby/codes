package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 17:14
 * @Description:
 */
public class _0063_maxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int res = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            }
            if (res < price - minPrice) {
                res = price - minPrice;
            }
        }
        return res;
    }

    // 另一种简化版本
    public int maxProfit1(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            res = Math.max(res, price - minPrice);
        }
        return res;
    }
}
