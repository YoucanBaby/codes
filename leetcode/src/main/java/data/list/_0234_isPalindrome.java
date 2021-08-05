package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 20:35
 * @Description:
 */
public class _0234_isPalindrome {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;

        _0234_isPalindrome solution = new _0234_isPalindrome();
        System.out.println(solution.isPalindrome(head));
    }



    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后一半的链表
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        // 比较两个链表
        ListNode leftHead = head;
        ListNode rightHead = pre;
        while (leftHead!= null && rightHead != null) {
            if (leftHead.val != rightHead.val) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }
}
