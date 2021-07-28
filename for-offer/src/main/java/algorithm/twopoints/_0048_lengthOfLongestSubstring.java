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

        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = -1;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(arr[right])) {
                left = Math.max(left, map.get(arr[right]));
            }
            map.put(arr[right], right);
            res = Math.max(res, right - left);
        }

        return res;
    }
}
