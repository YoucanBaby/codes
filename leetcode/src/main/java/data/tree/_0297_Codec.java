package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 11:25
 * @Description:
 */
public class _0297_Codec {


    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if (node != null) {
                sb.append(node.val + ",");
                deque.addLast(node.left);
                deque.addLast(node.right);
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
        data = data.substring(1, data.length() - 1);            // 去除两端的括号
        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        int index = 1;
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();

            if (!arr[index].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(arr[index]));
                deque.addLast(node.left);
            }
            index++;
            if (!arr[index].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(arr[index]));
                deque.addLast(node.right);
            }
            index++;
        }
        return root;
    }
}
