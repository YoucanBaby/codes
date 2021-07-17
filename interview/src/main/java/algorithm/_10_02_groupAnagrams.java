package algorithm;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-18 01:46
 * @Description:
 */
public class _10_02_groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];

        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
