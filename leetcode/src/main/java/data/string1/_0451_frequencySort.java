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

    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();

            // 用哈希表计数
            for (char c: s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // 哈希表转list
            List<Map.Entry<Character, Integer>> list =
                    new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());

            // 对list排序
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            StringBuilder sb = new StringBuilder();

            for (Map.Entry<Character, Integer> entry: list) {
                int N = entry.getValue();

                for (int i = 0; i < N; i++) {
                    sb.append(entry.getKey());
                }
            }

            return sb.toString();
        }
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
