package data.tree;

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

    // 思路3：颜色标记法
    public List<Integer> preorderTraversal(TreeNode root) {
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
                if (cn.node.left != null) {
                    stack.addFirst(new ColorNode(cn.node.left, 0));
                }
                stack.addFirst(new ColorNode(cn.node, 1));
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

    // 思路2：迭代，用栈模拟。
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);

        while (!stack.isEmpty()) {
            root = stack.removeFirst();
            res.add(root.val);

            if (root.right != null) {
                stack.addFirst(root.right);
            }
            if (root.left != null) {
                stack.addFirst(root.left);
            }
        }

        return res;
    }

    // 思路1：递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preoder(root, res);
        return res;
    }

    private void preoder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preoder(root.left, res);
        preoder(root.right, res);
    }
}
