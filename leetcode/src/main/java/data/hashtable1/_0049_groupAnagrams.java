package data.hashtable1;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-19 13:40
 * @Description:
 */
public class _0049_groupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        _0049_groupAnagrams solution = new _0049_groupAnagrams();

        List list = solution.groupAnagrams(strs);
        System.out.println(list);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];

        for (String str: strs) {
            Arrays.fill(count, 0);
            for (char c: str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}
