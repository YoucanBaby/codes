package data.list;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-04 19:28
 * @Description:
 */
public class _0025_reverseKGroup {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;

        _0025_reverseKGroup solution = new _0025_reverseKGroup();
        ListNode res = solution.reverseKGroup(head, 2);

        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode leftNodePre = newHead;
        ListNode rightNode = newHead;
        for (int i = 0; i < k; i++) {
            rightNode = rightNode.next;
            if (rightNode == null) {
                return newHead.next;
            }
        }
        ListNode rightNodeNext = rightNode.next;
        ListNode[] res = reverseList(leftNodePre.next, rightNode);
        leftNodePre.next = res[0];
        res[1].next = rightNodeNext;

        while (rightNode != null) {
            leftNodePre = res[1];
            rightNode = res[1];
            for (int i = 0; i < k; i++) {
                rightNode = rightNode.next;
                if (rightNode == null) {
                    return newHead.next;
                }
            }
            rightNodeNext = rightNode.next;
            res = reverseList(leftNodePre.next, rightNode);
            leftNodePre.next = res[0];
            res[1].next = rightNodeNext;
        }

        return newHead.next;
    }

    // 返回反转之后链表的起始节点
    public ListNode[] reverseList(ListNode leftNode, ListNode rightNode) {
        ListNode pre = null;
        ListNode cur = leftNode;
        ListNode rightNodeNext = rightNode.next;

        while (cur != rightNodeNext) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return new ListNode[] {rightNode, leftNode};
    }


    // 递归
    class solution {
        /** 反转区间 [a, b) 的元素，注意是左闭右开 */
        ListNode reverse(ListNode leftNode, ListNode rightNode) {
            ListNode pre = null;
            ListNode cur = leftNode;
            ListNode next = leftNode;
            while (cur != rightNode) {
                next = cur.next;
                cur.next = pre;

                pre = cur;
                cur = next;
            }
            return pre;		// 返回反转后的头结点
        }

        ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            // 区间 [a, b) 包含 k 个待反转元素
            ListNode leftNode = head;
            ListNode rightNode = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转，base case
                if (rightNode == null) {
                    return head;
                }
                rightNode = rightNode.next;
            }
            ListNode newHead = reverse(leftNode, rightNode);	// 反转前 k 个元素
            leftNode.next = reverseKGroup(rightNode, k);		// 递归反转后续链表并连接起来
            return newHead;
        }
    }
}
