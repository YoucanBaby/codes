package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 12:10
 * @Description:
 */
public class _0430_flatten {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    Node tail = null;
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            if (cur.next == null) {
                tail = cur;
            }

            if (cur.child != null) {
                Node temp = cur.next;
                Node child = flatten(cur.child);

                cur.next = child;
                child.prev = cur;
                cur.child = null;

                if (tail != null && temp != null) {
                    tail.next = temp;
                    temp.prev = tail;
                    tail = null;
                }
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
