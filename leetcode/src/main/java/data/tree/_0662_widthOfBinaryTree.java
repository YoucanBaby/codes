package data.tree;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 15:34
 * @Description:
 */
public class _0662_widthOfBinaryTree {


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 1;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        LinkedList<Integer> list = new LinkedList<>();         // 存放节点下标
        list.add(1);

        while (!deque.isEmpty()) {
            int N = deque.size();
            for (int i = 0; i < N; i++) {
                TreeNode node = deque.removeFirst();
                int index = list.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                    list.addLast(index * 2);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                    list.addLast(index * 2 + 1);
                }
            }
            if (list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;
    }


    class Solution {

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            Deque<Integer> index = new ArrayDeque<>();
            index.addLast(1);

            int res = 1;
            while (!deque.isEmpty()) {
                int size = deque.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    int nowIndex = index.removeFirst();
                    if (node.left != null) {
                        deque.addLast(node.left);
                        index.addLast(nowIndex * 2);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                        index.addLast(nowIndex * 2 + 1);
                    }
                }
                if (!index.isEmpty()) {
                    res = Math.max(res, index.getLast() - index.getFirst() + 1);
                }
            }
            return res;
        }
    }
}
