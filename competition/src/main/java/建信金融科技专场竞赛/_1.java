package 建信金融科技专场竞赛;

/**
 * @BelongsProject: codes
 * @BelongsPackage: 建信金融科技专场竞赛
 * @author: xuyifang
 * @CreateTime: 2021-10-29-18:59
 * @description:
 * @version: 1.0
 */
public class _1 {

    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode deleteListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return head;
    }
}
