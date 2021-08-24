package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 20:27
 * @Description:
 */
public class _1028_recoverFromPreorder {


    public TreeNode recoverFromPreorder(String s) {
        Deque<TreeNode> stack = new ArrayDeque<>();         // 左边是栈顶

        int i = 0;
        while (i < s.length()) {
            int level = 0;          // 当前节点在第几层
            while (i < s.length() && s.charAt(i) == '-') {
                level++;
                i++;
            }

            int val = 0;            // 当前节点的值
            while (i < s.length() && s.charAt(i) != '-') {
                val = val * 10 + (s.charAt(i) - '0');
                i++;
            }

            while (stack.size() > level) {
                stack.removeLast();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.getLast().left == null) {
                    stack.getLast().left = node;
                } else {
                    stack.getLast().right = node;
                }
            }
            stack.addLast(node);
        }

        while (stack.size() > 1) {
            stack.removeLast();
        }
        return stack.removeLast();
    }
}
