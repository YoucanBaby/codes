package algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 10:27
 * @Description:
 */
public class _0763_partitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r, last[s.charAt(i) - 'a']);
            if (i == r) {
                res.add(r - l + 1);
                l = r + 1;
            }
        }
        return res;
    }
}
