package algorithm.twopoints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoints
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 14:34
 * @Description:
 */
public class _0048_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (!set.isEmpty() && set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, set.size());
        }
        return res;
    }
}
