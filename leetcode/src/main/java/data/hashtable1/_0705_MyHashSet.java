package data.hashtable1;

import java.util.LinkedList;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 15:43
 * @Description:
 */
public class _0705_MyHashSet {
}

class MyHashSet {

    boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];       // 最大数据只有10^6
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}


class MyHashSet2 {

    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashSet2() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);

        for (int num: (LinkedList<Integer>) data[h]) {
            if (num == key) {
                return;
            }
        }
        data[h].addLast(key);
    }

    public void remove(int key) {
        int h = hash(key);

        int index = 0;
        for (int num: (LinkedList<Integer>) data[h]) {
            if (num == key) {
                data[h].remove(index);
                return;
            }
            index++;
        }
    }

    public boolean contains(int key) {
        int h = hash(key);

        for (int num: (LinkedList<Integer>) data[h]) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}