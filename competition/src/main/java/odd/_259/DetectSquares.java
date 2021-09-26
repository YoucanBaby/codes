package odd._259;

import java.util.*;

class DetectSquares {

    Map<Integer, Integer> map = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] p) {
        int key = getKey(p[0], p[1]);
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] p) {
        int x = p[0], y = p[1];
        int res = 0;
        for (int key : map.keySet()) {
            int x1 = key / 10000;
            int y1 = key % 10000;
            if (Math.abs(x1 - x) == Math.abs(y1 - y) && x1 != x) {
                int key2 = getKey(x1, y);
                int key3 = getKey(x, y1);
                if (!map.containsKey(key2) || !map.containsKey(key3)) continue;
                res += map.get(key) * map.get(key2) * map.get(key3);
            }
        }
        return res;
    }

    private int getKey(int x, int y) {
        return x * 10000 + y;
    }
}