package data.tree;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 13:41
 * @Description:
 */
public class _0109_sortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head);
    }

    public TreeNode dfs(ListNode head) {
        if (head == null) {
            return null;
        }

        // 只有一个节点提前返回
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 快慢指针找中心节点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        // 断开节点，避免成环
        pre.next = null;
        slow.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head);
        root.right = dfs(next);

        return root;
    }

}
