package algorithm.twopoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-17 08:33
 * @Description:
 */
public class _0030_findSubstring {


    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> freq = new HashMap<>();    // word词频
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        int oneWordLen = words[0].length();             // 一个字符串的长度
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < oneWordLen; i++) {
            Map<String, Integer> tFreq = new HashMap<>();
            int count = 0;
            int left = i;
            for (int right = i; right < s.length() - oneWordLen + 1; right += oneWordLen) {
                String word = s.substring(right, right + oneWordLen);
                tFreq.put(word, tFreq.getOrDefault(word, 0) + 1);
                count++;
                while (tFreq.getOrDefault(word, 0) > freq.getOrDefault(word, 0)) {
                    String temp = s.substring(left, left + oneWordLen);
                    tFreq.put(temp, tFreq.getOrDefault(temp, 0) - 1);
                    count--;
                    left += oneWordLen;
                }
                if (count == words.length) {
                    res.add(left);
                }
            }
        }
        return res;
    }

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            Map<String, Integer> freq = new HashMap<>();
            for (String word : words) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }

            List<Integer> res = new ArrayList<>();
            int oneWordLen = words[0].length();          // 一个字符串的长度
            int windowLen = oneWordLen * words.length;   // 滑动窗口的长度，字符串数组中每个字符串的长度都一样长

            for (int left = 0; left < s.length() - windowLen + 1; left++) {
                String t = s.substring(left, left + windowLen);
                Map<String, Integer> tFreq = new HashMap<>(freq);
                for (int right = 0; right < windowLen; right += oneWordLen) {
                    String word = t.substring(right, right + oneWordLen);
                    if (tFreq.containsKey(word)) {
                        tFreq.put(word, tFreq.get(word) - 1);
                        if (tFreq.get(word) == 0) {
                            tFreq.remove(word);
                        }
                    } else {
                        break;
                    }
                }
                if (tFreq.size() == 0) {
                    res.add(left);
                }
            }
            return res;
        }
    }
}
