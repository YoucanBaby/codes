package algorithm.twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 10:06
 * @Description:
 */
public class _0159_lengthOfLongestSubstringTwoDistinct {


    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();      // <字符, 字符出现次数>
        int res = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() == 3) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
