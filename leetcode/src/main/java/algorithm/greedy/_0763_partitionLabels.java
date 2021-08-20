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
        int[] lastIndex = new int[26];
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            right = Math.max(right, lastIndex[s.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
