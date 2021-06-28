package data.tree;

import sun.reflect.generics.tree.Tree;

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

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.addFirst(root);
                root = root.left;
            } else {
                root = stack.removeFirst();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<ColorNode> stack = new ArrayDeque<>();
        if (root == null) {
            return ret;
        }
        stack.addFirst(new ColorNode(root, 0));

        while (!stack.isEmpty()) {
            ColorNode cn = stack.removeFirst();

            if (cn.color == 0) {
                if (cn.node.right != null) {
                    stack.addFirst(new ColorNode(cn.node.right, 0));
                }
                stack.addFirst(new ColorNode(cn.node, 1));
                if (cn.node.left != null) {
                    stack.addFirst(new ColorNode(cn.node.left, 0));
                }
            } else {
                ret.add(cn.node.val);
            }
        }
        return ret;
    }

    private class ColorNode {
        TreeNode node;
        int color;

        public ColorNode(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorder(root, ret);
        return ret;
    }

    private void inorder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        inorder(root.left, ret);
        ret.add(root.val);
        inorder(root.right, ret);
    }
}
