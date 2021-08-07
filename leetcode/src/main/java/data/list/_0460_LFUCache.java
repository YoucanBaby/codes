package data.list;

import java.util.HashMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-06 08:43
 * @Description:
 */
public class _0460_LFUCache {

    class LFUCache {
        HashMap<Integer, Node> cache;           // <key, Node>
        HashMap<Integer, DoubleList> freqMap;   // <freq, DoubleList>
        int cap;            // 最大容量
        int minFreq;        // 存储当前最小频次

        public LFUCache(int capacity) {
            cache = new HashMap<>();
            freqMap = new HashMap<>();
            cap = capacity;
            minFreq = 0;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            int val = cache.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = val;
                update(node, false);
            } else {
                if(cap == 0) {
                    return;
                }
                if (cache.size() == cap) {
                    deleteRemoteMinFreqNode();
                }
                Node node = new Node(key,val);
                update(node, true);
                cache.put(key, node);
            }
        }

        private void update(Node node, boolean isNewNode) {
            if(isNewNode) {
                minFreq = 1;
                addNodeInFreqMap(node);
            }
            else {
                deleteNodeInFreqMap(node);
                node.freq++;
                addNodeInFreqMap(node);
                if(!freqMap.containsKey(minFreq)) {
                    minFreq++;
                }
            }
        }

        private void addNodeInFreqMap(Node node) {
            if (!freqMap.containsKey(node.freq)) {
                freqMap.put(node.freq, new DoubleList());
            }
            DoubleList list = freqMap.get(node.freq);
            list.addFirst(node);
        }

        private void deleteNodeInFreqMap(Node node) {
            DoubleList list = freqMap.get(node.freq);
            list.delete(node);
            if (list.isEmpty()) {
                freqMap.remove(node.freq);
            }
        }

        private void deleteRemoteMinFreqNode() {
            DoubleList list = freqMap.get(minFreq);
            if (!list.isEmpty()) {
                Node node = list.tail.pre;
                list.delete(node);
                cache.remove(node.key);
            }
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

        public boolean isEmpty() {
            return head.next == tail;
        }
    }

    class Node {
        int key;
        int val;
        int freq;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
}
