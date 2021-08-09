package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 00:16
 * @Description:
 */
public class _1833_maxIceCream {

    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        _1833_maxIceCream solution = new _1833_maxIceCream();

        System.out.println(solution.maxIceCream(costs, coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[(int) (1e5 + 1)];
        for (int cost: costs) {
            freq[cost]++;
        }
        int res = 0;
        for (int cost = 1; cost < freq.length; cost++) {
            if (coins < cost) {
                break;
            } else {
                int minCount = Math.min(freq[cost], coins / cost);      // 最多可以买多少根
                coins -= cost * minCount;
                res += minCount;
            }
        }
        return res;
    }
}
