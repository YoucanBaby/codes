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

    static int BASE = 769;
    LinkedList[] data = new LinkedList[BASE];;

    public MyHashSet() {
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        for (int num : (LinkedList<Integer>) data[h]) {
            if (num == key) return;
        }
        data[h].addLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        int index = 0;
        for (int num : (LinkedList<Integer>) data[h]) {
            if (num == key) {
                data[h].remove(index);
                return;
            }
            index++;
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        for (int num : (LinkedList<Integer>) data[h]) {
            if (num == key) return true;
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}