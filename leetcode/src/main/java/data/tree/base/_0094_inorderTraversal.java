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

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();

            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    if (node.right != null) stack.push(node.right);
                    stack.push(node);
                    stack.push(null);
                    if (node.left != null) stack.push(node.left);
                } else {
                    res.add(stack.pop().val);
                }
            }
            return res;
        }
    }
}
