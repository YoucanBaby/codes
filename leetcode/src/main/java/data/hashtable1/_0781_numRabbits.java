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

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            if (!map.containsKey(answers[i])) {
                map.put(answers[i], 1);
            } else {
                map.put(answers[i], map.get(answers[i]) + 1);
            }
        }

        int ret = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int y = entry.getKey();
            int x = entry.getValue();
            ret += (x + y) / (y + 1) * (y + 1);
        }
        return ret;
    }
}
