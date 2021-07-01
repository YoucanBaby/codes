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

        System.out.println(solution.maxIceCream2(costs, coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                res++;
            } else {
                break;
            }
        }

        return res;
    }

    public int maxIceCream2(int[] costs, int coins) {
        int[] freq = new int[100001];

        for (int cost: costs) {
            freq[cost]++;
        }

        int res = 0;
        for (int i = 1; i <= freq.length; i++) {
            if (coins >= i) {
                int minCount = Math.min(freq[i], coins / i);
                coins -= i * minCount;
                res += minCount;
            } else {
                break;
            }
        }
        return res;
    }
}
