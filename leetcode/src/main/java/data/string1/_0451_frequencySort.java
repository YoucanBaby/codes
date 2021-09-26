package data.string1;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-03 01:17
 * @Description:
 */
public class _0451_frequencySort {

    public String frequencySort(String s) {
        int[] freq = new int[128];
        int maxFreq = 0;
        for (char c : s.toCharArray()) {
            freq[c]++;
            maxFreq = Math.max(maxFreq, freq[c]);
        }

        List<Character>[] list = new ArrayList[maxFreq + 1];
        for (int i = 0; i < list.length; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            list[freq[i]].add((char) i);
        }

        StringBuilder res = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            for (char c : list[i]) {
                for (int j = 0; j < i; j++) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    class Solution1 {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();

            // 用哈希表计数
            for (char c: s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // 将出现频率为 i 的字符放到第 i 个桶里（即 buckets[i]）
            List<Character>[] buckets = new List[s.length() + 1];

            // 遍历哈希表，把元素加入到桶里
            for (char key: map.keySet()) {
                int value = map.get(key);

                if (buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add(key);
            }

            // 遍历桶得到结果
            StringBuilder sb = new StringBuilder();

            for (int i = buckets.length - 1; i >= 0; i--) {
                // 如果桶里有字符
                if (buckets[i] != null) {
                    // 遍历这些字符
                    for (char c: buckets[i]) {
                        // 字符出现了几次就添加几次
                        for (int j = 0; j < i; j++) {
                            sb.append(c);
                        }
                    }
                }
            }

            return sb.toString();
        }
    }
}
