package data.list;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 14:12
 * @Description:
 */
public class _0708_insert {

    class Node {
        int val;
        Node next;

        Node() { }
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val;this.next = next; }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node cur = head;
        while (cur.next != head) {
            if (cur.val <= insertVal && insertVal <= cur.next.val) {
                break;
            } else if (cur.val < insertVal && cur.next.val < insertVal && cur.val > cur.next.val) {
                // insertVal是最大值
                break;
            } else if (cur.val > insertVal && cur.next.val > insertVal && cur.val > cur.next.val) {
                // insertVal是最小值
                break;
            } else {
                cur = cur.next;
            }
        }
        Node temp = cur.next;
        cur.next = new Node(insertVal, temp);

        return head;
    }
}
