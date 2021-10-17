package data.hashtable1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 16:22
 * @Description:
 */
public class _0706_MyHashMap {
    class MyHashMap {

        class Pair {
            int key;
            int val;

            Pair(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        static final int SIZE = 769;
        LinkedList<Pair>[] list = new LinkedList[SIZE];

        public MyHashMap() {
            for (int i = 0; i < SIZE; ++i) {
                list[i] = new LinkedList();
            }
        }

        private int getHash(int key) {
//            int hash = Objects.hashCode(key) ^ (Objects.hashCode(key) >>> 16);
//            return hash & (SIZE - 1);
            return key % SIZE;
        }

        public void put(int key, int val) {
            int hash = getHash(key);
            for (Pair pair : list[hash]) {
                if (pair.key == key)  {
                    pair.val = val;
                    return;
                }
            }
            list[hash].add(new Pair(key, val));
        }

        public int get(int key) {
            int hash = getHash(key);
            for (Pair pair : list[hash]) {
                if (pair.key == key) return pair.val;
            }
            return -1;
        }

        public void remove(int key) {
            int hash = getHash(key);
            for (int i = 0; i < list[hash].size(); i++) {
                if (list[hash].get(i).key == key) {
                    list[hash].remove(i);
                    return;
                }
            }
        }
    }
}

class MyHashMap2 {

    static final int INF = Integer.MAX_VALUE;
    int[] map;

    public MyHashMap2() {
        map = new int[1000001];     // 最大数据只有10^6
        Arrays.fill(map, INF);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key] == INF ? -1 : map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = INF;
    }
}

