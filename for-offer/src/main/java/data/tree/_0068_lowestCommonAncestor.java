package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-27 21:02
 * @Description:
 */
public class _0068_lowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            // 遍历右子树
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            // 遍历左子树
            else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }

        return root;
    }
}
