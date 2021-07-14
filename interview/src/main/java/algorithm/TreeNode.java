package algorithm;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 14:50
 * @Description:
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() { }

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
