package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 10:48
 * @Description:
 */
public class _0701_insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }


    public TreeNode insertIntoBST2(TreeNode root, int val) {
        // 处理特殊情况
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode node = new TreeNode(val);
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                } else {
                    cur = cur.left;
                }
            }
            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }
}
