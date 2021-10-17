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
                res.add(stack.removeFirst().val);
            }
        }
        return res;
    }

    // 思路1：递归

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    // 练习迭代
    class Solution {
        // 栈非空，就取出栈顶节点
        // 如果栈顶节点非空，则加入右左 根(当前节点)，根后面加null；
        // 如果栈顶节点为空，则弹出现在的栈顶节点，把它加入到结果中
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();

            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                    stack.push(node);
                    stack.push(null);
                } else {
                    res.add(stack.pop().val);
                }
            }
            return res;
        }
    }
}
