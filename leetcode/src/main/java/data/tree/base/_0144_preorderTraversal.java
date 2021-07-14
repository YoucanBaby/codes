package data.tree.base;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 14:47
 * @Description:
 */
public class _0144_preorderTraversal {

    public static void main(String[] args) {

    }

    // 迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            if (node != null) {
                if (node.right != null) {       // 右
                    stack.addFirst(node.right);
                }
                if (node.left != null) {        // 左
                    stack.addFirst(node.left);
                }
                stack.addFirst(node);           // 中
                stack.addFirst(null);
            } else {
                node = stack.removeFirst();
                res.add(node.val);
            }
        }

        return res;
    }

    // 思路1：递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
