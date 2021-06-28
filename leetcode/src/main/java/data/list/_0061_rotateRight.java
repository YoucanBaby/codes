package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 01:27
 * @Description:
 */
public class _0061_rotateRight {


    public static void main(String[] args) {

    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 计算链表长度
        int N = 1;
        ListNode cur = head;
        while (cur.next != null) {
            N++;
            cur = cur.next;
        }

        // 更新k
        k %= N;
        if (k == 0) {
            return head;
        }

        // 把链表从n - k处断开，
        ListNode tail = head;
        for (int i = 0; i < N - k - 1; i++) {
            tail = tail.next;
        }

        // 将后面的链表的尾部指向前面的链表的头部，前面链表的尾部指向null
        ListNode newHead = tail.next;

        tail.next = null;
        cur.next = head;

        return newHead;
    }
}
