package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 19:23
 * @Description:
 */
public class _0037_Codec {

    // 层序遍历
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);

        StringBuilder sb = new StringBuilder("[");

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            if (node != null) {
                sb.append(node.val).append(",");
                deque.addFirst(node.left);
                deque.addFirst(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }

        data = data.substring(1, data.length() - 1);
        String[] strs = data.split(",");

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        deque.addFirst(root);

        int i = 1;
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();

            if (!strs[i].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(strs[i]));
                deque.addFirst(node.left);
            }
            i++;

            if (!strs[i].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(strs[i]));
                deque.addFirst(node.right);
            }
            i++;
        }

        return root;
    }
}
