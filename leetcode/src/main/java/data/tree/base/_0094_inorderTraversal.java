package data.tree.base;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 15:09
 * @Description:
 */
public class _0094_inorderTraversal {

    public static void main(String[] args) {

    }

    // 迭代
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            if (node != null) {
                if (node.right != null) {
                    stack.addFirst(node.right);     // 右
                }
                stack.addFirst(node);               // 中
                stack.addFirst(null);
                if (node.left != null) {
                    stack.addFirst(node.left);      // 左
                }
            } else {
                res.add(stack.removeFirst().val);
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
