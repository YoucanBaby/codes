package data.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 23:52
 * @Description:
 */
public class _0146_LRUCache {

    class Node {
        int key, val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        Node head;
        Node tail;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.pre = head;

            head.next.pre = node;
            head.next = node;
        }

        public int delete(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node.key;
        }

        public int deleteLast() {
            if (head.next == tail) {
                return -1;
            }
            return delete(tail.pre);
        }
    }

    class LRUCache {
        Map<Integer, Node> map;
        DoubleList list;
        int size;

        public LRUCache (int capacity) {
            map = new HashMap<>();
            list = new DoubleList();
            size = capacity;
        }

        public void put(int key, int val) {
            Node newNode = new Node(key, val);
            if (map.containsKey(key)) {
                list.delete(map.get(key));
                list.addFirst(newNode);
                map.put(key, newNode);
            } else {
                if (map.size() == size) {
                    int lastKey = list.deleteLast();
                    map.remove(lastKey);
                }
                list.addFirst(newNode);
                map.put(key, newNode);
            }
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            put(key, map.get(key).val);
            return map.get(key).val;
        }
    }


    // 练习
    // 由哈希表+双向链表完成
    // 节点：key, val, pre, next
    // 双向链表(左边最新，右边最久)：head, tail
        // 头部添加
        // int 删除
        // int 尾部删除
    // LRU：哈希表，双向链表，双向链表的最大容量
        // put : 如果双向链表里有这个节点，则删除这个节点，在开头添加这个节点，更新哈希表
        //       如果没有这个节点，如果容量满了，就删除尾巴的节点，更新哈希表；最后在开头添加这个节点，更新哈希表
        // get : 如果没有这个key，返回-1；有的话，就put一个新的。

    class Solution {

        class LRUCache {

            public LRUCache (int capacity) {

            }

            public void put(int key, int val) {

            }

            public int get(int key) {
                return 0;
            }
        }
    }
}




























