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

    // 使用链表数组实现，链表长度超过8，链表转为红黑树
    // 默认负载因子为0.75，数组长度为769，超过0.75就扩容，扩容后的大小为原大小的两倍
    // 哈希函数是 x % 769

    final int SIZE = 769;
    LinkedList<Integer>[] list = new LinkedList[SIZE];

    public MyHashSet() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList();
        }
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int hash = getHash(key);
        for (int num : list[hash]) {
            if (num == key) return;
        }
        list[hash].add(key);
    }

    public void remove(int key) {
        int hash = getHash(key);
        for (int i = 0; i < list[hash].size(); i++) {
            if (list[hash].get(i) == key) {
                list[hash].remove(i);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = getHash(key);
        for (int num : list[hash]) {
            if (num == key) return true;
        }
        return false;
    }
}