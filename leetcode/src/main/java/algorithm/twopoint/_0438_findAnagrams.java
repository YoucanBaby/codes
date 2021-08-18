package algorithm.twopoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-17 19:26
 * @Description:
 */
public class _0438_findAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int[] needs = new int[128];
        for (char c : p.toCharArray()) {
            needs[c]++;
        }
        int[] window = new int[128];

        List<Integer> res = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right)]++;
            while (window[s.charAt(right)] > needs[s.charAt(right)]) {
                window[s.charAt(left)]--;
                left++;
            }
            if (right - left + 1 == p.length()) {
                res.add(left);
            }
        }
        return res;
    }
}
