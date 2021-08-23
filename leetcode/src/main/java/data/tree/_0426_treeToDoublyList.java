package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 13:47
 * @Description:
 */
public class _0426_treeToDoublyList {


    class Solution {
        Node head;
        Node pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            head.left = pre;
            pre.right = head;

            return head;
        }

        private void dfs(Node root) {
            if (root == null) {
                return;
            }

            dfs(root.left);
            if (head == null) {
                head = root;
            } else {
                root.left = pre;
                pre.right = root;
            }
            pre = root;
            dfs(root.right);
        }
    }

}
