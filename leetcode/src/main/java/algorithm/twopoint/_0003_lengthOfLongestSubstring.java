package algorithm.twopoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 16:16
 * @Description:
 */
public class _0003_lengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int N = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < N; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, set.size());
        }
        return res;
    }
}
