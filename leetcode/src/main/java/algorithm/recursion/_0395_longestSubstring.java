package algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-08-16 16:53
 * @Description:
 */
public class _0395_longestSubstring {


    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        Map<Character, Integer> freq = new HashMap<>();      // <字符，字符出现的频率>
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char c : freq.keySet()) {
            if (freq.get(c) >= k) {
                continue;
            }

            int max = 0;
            for (String splitS : s.split(c + "")) {
                max = Math.max(max, longestSubstring(splitS, k));
            }
            return max;
        }
        return s.length();
    }
}
