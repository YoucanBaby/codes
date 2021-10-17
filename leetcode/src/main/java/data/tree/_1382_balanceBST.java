package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 14:26
 * @Description:
 */
public class _1382_balanceBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = root;
        node.right = new TreeNode(2);
        node = node.right;
        node.right = new TreeNode(3);
        node = node.right;
        node.right = new TreeNode(4);

        _1382_balanceBST solution = new _1382_balanceBST();

        solution.balanceBST(root);
    }



    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bst2List(list, root);
        return dfs(list, 0, list.size() - 1);
    }

    public TreeNode dfs(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = dfs(list, left, mid - 1);
        root.right = dfs(list, mid + 1, right);

        return root;
    }

    public void bst2List(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        bst2List(list, root.left);
        list.add(root.val);         // 中序遍历
        bst2List(list, root.right);
    }


}
