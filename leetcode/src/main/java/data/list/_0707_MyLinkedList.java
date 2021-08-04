package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 03:37
 * @Description:
 */
public class _0707_MyLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class MyLinkedList {

        int size;
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode();      // 虚假头节点
        }

        // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。下标从0开始计算。
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        // 将值为 val 的节点追加到链表的最后一个元素。
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        // 在链表中的第 index 个节点之前添加值为 val 的节点。
        // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
        // 如果 index 大于链表长度，则不会插入节点。
        // 如果 index 小于0，则在头部插入节点。
        public void addAtIndex(int index, int val) {
            if (index == size) {
                ListNode cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = new ListNode(val);
                size++;
            } else if (index > size) {
                return;
            } else if (index <= 0) {
                ListNode next = head.next;
                head.next = new ListNode(val, next);
                size++;
            } else {
                ListNode cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                cur.next = new ListNode(val, next);
                size++;
            }
        }

        // 如果索引 index 有效，则删除链表中的第 index 个节点。
        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                ListNode cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                size--;
            }
        }
    }
}

