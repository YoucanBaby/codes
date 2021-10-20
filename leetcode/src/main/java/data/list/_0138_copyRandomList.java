package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 10:35
 * @Description:
 */
public class _0138_copyRandomList {

    class Node {
        int val;
        Node next = null;
        Node random = null;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 构建新链表
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = cur.next.next;
        }

        // 构建新链表的random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 拆分链表
        Node newHead = head.next;
        cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = cur.next.next;
            if (cur.next != null) {
                temp.next = cur.next.next;
            }
            cur = cur.next;
        }

        return newHead;
    }

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        // 构建新链表
        Node cur = head;
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        // 构建random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分链表
        cur = head;
        Node newHead = head.next;
        while (cur != null) {
            Node next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            if (cur != null) {
                next.next = cur.next;
            }
        }
        return newHead;
    }
}
