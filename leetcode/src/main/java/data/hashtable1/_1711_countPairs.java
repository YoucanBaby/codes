package data.hashtable1;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 15:03
 * @Description:
 */
public class _1711_countPairs {

    public static void main(String[] args) {
        int[] ds = {1,1,1,3,3,3,7};
        _1711_countPairs solution = new _1711_countPairs();

        System.out.println(solution.countPairs(ds));
    }

    public int countPairs(int[] ds) {
        int MOD = (int) (1e9 + 7);
        int MAX = 1 << 20;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int a : ds) {
            for (int b = 1; b <= MAX; b <<= 1) {
                int c = b - a;
                res += map.getOrDefault(c, 0);
                if (res >= MOD) {
                    res -= MOD;
                }
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return res;
    }
}
