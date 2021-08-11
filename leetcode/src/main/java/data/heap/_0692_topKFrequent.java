package data.heap;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.heap
 * @Author: xuyifang
 * @CreateTime: 2021-08-11 02:42
 * @Description:
 */
public class _0692_topKFrequent {


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue().compareTo(a.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        List<String> res = new ArrayList<>();
        while (pq.size() > map.size() - k) {
            res.add(pq.remove().getKey());
        }
        return res;
    }
}
