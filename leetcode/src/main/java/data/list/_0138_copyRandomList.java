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
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
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
}
