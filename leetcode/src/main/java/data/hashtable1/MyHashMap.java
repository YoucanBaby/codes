package data.hashtable1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 14:50
 * @Description:
 */
class MyHashMap {

    class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static final int BASE = 769;
    LinkedList[] data = new LinkedList[BASE];

    public MyHashMap() {
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int val) {
        int h = hash(key);
        for (Pair pair : (LinkedList<Pair>) data[h]) {
            if (pair.key == key) {
                pair.val = val;
                return;
            }
        }
        data[h].addLast(new Pair(key, val));
    }

    public int get(int key) {
        int h = hash(key);
        for (Pair pair : (LinkedList<Pair>) data[h]) {
            if (pair.key == key) {
                return pair.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        for (Pair pair : (LinkedList<Pair>) data[h]) {
            if (pair.key == key) {
                data[h].remove(pair);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
