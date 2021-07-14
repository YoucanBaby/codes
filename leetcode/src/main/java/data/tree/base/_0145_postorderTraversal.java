package data.tree.base;


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
                stack.addFirst(node);               // 中
                stack.addFirst(null);
                if (node.right != null) {
                    stack.addFirst(node.right);     // 右
                }
                if (node.left != null) {
                    stack.addFirst(node.left);      // 左
                }
            } else {
                node = stack.removeFirst();
                res.add(node.val);
            }
        }

        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
