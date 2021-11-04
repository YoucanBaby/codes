package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 20:46
 * @Description:
 */
public class _0513_findBottomLeftValue {


    // DFS
    int res = 0;
    int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > maxDepth) {
            res = root.val;
            maxDepth = depth;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    class Solution {

        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            int res = -1;

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                    if (i == 0) res = node.val;
                }
            }
            return res;
        }
    }
}
