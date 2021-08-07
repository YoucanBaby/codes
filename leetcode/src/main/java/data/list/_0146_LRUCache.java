package data.list;

import java.util.HashMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 23:52
 * @Description:
 */
public class _0146_LRUCache {


    class LRUCache {
        HashMap<Integer, Node> map;
        DoubleList cache;
        int cap;

        public LRUCache (int capacity) {
            map = new HashMap<>();
            cache = new DoubleList();
            cap = capacity;
        }

        public void put(int key, int val) {
            Node newNode = new Node(key, val);

            if (map.containsKey(key)) {
                cache.delete(map.get(key));
                cache.addFirst(newNode);
                map.put(key, newNode);
            } else {
                if (map.size() == cap) {
                    int k = cache.deleteLast();
                    map.remove(k);
                }
                cache.addFirst(newNode);
                map.put(key, newNode);
            }
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).val;
            put(key, val);
            return val;
        }
    }

    // 左边是最近使用，右边是LRU
    class DoubleList {
        Node head;
        Node tail;

        public DoubleList () {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst (Node node) {
            node.next = head.next;
            node.pre = head;

            head.next.pre = node;
            head.next = node;
        }

        public int delete (Node node) {
            int key = node.key;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return key;
        }

        public int deleteLast() {
            if (head.next == tail) {
                return -1;
            }
            return delete(tail.pre);
        }
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node (int key, int val) { this.key = key; this.val = val; }
    }

    class Solution {

        class LRUCache {
            HashMap<Integer, Node> map;
            DoubleList cache;
            int cap;

            public LRUCache (int capacity) {
                map = new HashMap<>();
                cache = new DoubleList();
                this.cap = capacity;
            }

            public void put(int key, int val) {
                Node newNode = new Node(key, val);

                if (map.containsKey(key)) {
                    cache.delete(map.get(key));
                    cache.addFirst(newNode);
                    map.put(key, newNode);
                } else {
                    if (cap == map.size()) {
                        int k = cache.deleteLast();
                        map.remove(k);
                    }
                    cache.addFirst(newNode);
                    map.put(key, newNode);
                }
            }

            public int get(int key) {
                if (!map.containsKey(key)) {
                    return -1;
                }
                int val = map.get(key).val;
                put(key, val);
                return val;
            }
        }

        class DoubleList {
            Node head;
            Node tail;
            public DoubleList() {
                head = new Node(0,0);
                tail = new Node(0,0);
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

        class Node {
            int key;
            int val;
            Node pre;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
