package odd._262;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._262
 * @Author: xuyifang
 * @CreateTime: 2021-10-10 11:39
 * @Description:
 */
class StockPrice {

    TreeMap<Integer, Integer> treeMap;
    TreeMap<Integer, Set<Integer>> prices;

    public StockPrice() {
        treeMap = new TreeMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        int lastPrice = Integer.MAX_VALUE;
        if (treeMap.containsKey(timestamp)) {
            lastPrice = treeMap.get(timestamp);
        }

        if (prices.containsKey(lastPrice)) {
            Set<Integer> set = prices.get(lastPrice);
            if (set.contains(timestamp)) {
                set.remove(timestamp);
            }
            if (set.size() == 0) {
                prices.remove(lastPrice);
            }
        }

        if (!prices.containsKey(price)) {
            Set<Integer> set = new HashSet<>();
            set.add(timestamp);
            prices.put(price, set);
        } else {
            Set<Integer> set = prices.get(price);
            set.add(timestamp);
            prices.put(price, set);
        }

        treeMap.put(timestamp, price);
    }

    public int current() {
        return treeMap.get(treeMap.lastKey());
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}
