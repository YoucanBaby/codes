package data.tree;

import data.list.ListNode;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 15:14
 * @Description:
 */
public class _0145_postorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        stack1.addFirst(root);

        Deque<TreeNode> stack2 = new ArrayDeque<>();

        while (!stack1.isEmpty()) {
            root = stack1.removeFirst();
            stack2.addFirst(root);
            if (root.left != null) {
                stack1.addFirst(root.left);
            }
            if (root.right != null) {
                stack1.addFirst(root.right);
            }
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.removeFirst().val);
        }

        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<ColorNode> stack = new ArrayDeque<>();
        if (root == null) {
            return ret;
        }
        stack.addFirst(new ColorNode(root, 0));

        while (!stack.isEmpty()) {
            ColorNode cn = stack.removeFirst();

            if (cn.color == 0) {
                stack.addFirst(new ColorNode(cn.node, 1));
                if (cn.node.right != null) {
                    stack.addFirst(new ColorNode(cn.node.right, 0));
                }
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

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorder(root, ret);
        return ret;
    }

    private void postorder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        postorder(root.left, ret);
        postorder(root.right, ret);
        ret.add(root.val);
    }
}
