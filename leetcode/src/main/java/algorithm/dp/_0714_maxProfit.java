package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 21:44
 * @Description:
 */
public class _0714_maxProfit {


    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;      // 买入价格
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {    // 遇到更低的价格，更新买入价格
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {   // 遇到更高的价格，卖出，并无费率的更新买入价格
                res += prices[i] - buy;
                buy = prices[i];
            }
        }
        return res;
    }
}
