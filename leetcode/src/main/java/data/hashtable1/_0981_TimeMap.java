package data.hashtable1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 04:34
 * @Description:
 */
public class _0981_TimeMap {

    class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> treeMap;
            if (map.get(key) == null) {
                treeMap = new TreeMap<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
            } else {
                treeMap = map.get(key);
            }
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }

        public String get(String key, int timestamp) {

            if (map.get(key) != null) {
                TreeMap<Integer, String> treeMap = map.get(key);
                for (Integer time : treeMap.keySet()) {
                    if (time <= timestamp) {
                        return treeMap.get(time);
                    }
                }
            }
            return "";
        }
    }
}
