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
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String val, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>((o1, o2) -> o2 - o1));
            }
            map.get(key).put(timestamp, val);
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                TreeMap<Integer, String> treeMap = map.get(key);
                for (int time : treeMap.keySet()) {
                    if (time <= timestamp) {
                        return treeMap.get(time);
                    }
                }
            }
            return "";
        }
    }
}
