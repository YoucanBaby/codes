package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 14:59
 * @Description:
 */
public class _04_03_listOfDepth {


    public ListNode[] listOfDepth(TreeNode root) {
        if (root == null) {
            return new ListNode[0];
        }

        List<ListNode> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            ListNode head = new ListNode();
            ListNode cur = head;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(head.next);
        }
        return res.toArray(new ListNode[0]);
    }
}
