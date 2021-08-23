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

    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        bst2List(root);                               // 二叉搜索树转为动态数组
        return dfs(0, list.size() - 1);     // 通过动态数组构造平衡的二叉搜索树
    }

    public TreeNode dfs(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = dfs(left, mid - 1);
        root.right = dfs(mid + 1, right);

        return root;
    }

    public void bst2List(TreeNode root) {
        if (root == null) {
            return;
        }
        bst2List(root.left);
        list.add(root.val);         // 中序遍历
        bst2List(root.right);
    }


}
