package data.hashtable1;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 16:37
 * @Description:
 */
public class _0781_numRabbits {

    public static void main(String[] args) {
        int[] answers = {1, 1, 2};
        _0781_numRabbits solution = new _0781_numRabbits();

        System.out.println(solution.numRabbits(answers));
    }

    public int numRabbits(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int y = entry.getKey();
            int x = entry.getValue();
            res += (x + y) / (y + 1) * (y + 1);         // (x + y)就是向上取整
        }
        return res;
    }
}
