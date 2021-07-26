package algorithm.greedy;

import java.util.Map;
import java.util.TreeMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-25 20:40
 * @Description:
 */
public class _0846_isNStraightHand {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            if (!map.containsKey(card)) {
                map.put(card, 1);
            } else {
                map.replace(card, map.get(card) + 1);
            }
        }

        while (!map.isEmpty()) {
            int first = map.firstKey();
            for (int card = first; card < first + W; card++) {
                if (!map.containsKey(card)) {
                    return false;
                }
                if (map.get(card) == 1) {
                    map.remove(card);
                } else {
                    map.replace(card, map.get(card) - 1);
                }
            }
        }
        return true;
    }
}
