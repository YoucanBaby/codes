package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 15:02
 * @Description:
 */
public class _1008_bstFromPreorder {


    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int max) {
        if (index == preorder.length || preorder[index] > max) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = dfs(preorder, root.val);
        root.right = dfs(preorder, max);

        return root;
    }
}
