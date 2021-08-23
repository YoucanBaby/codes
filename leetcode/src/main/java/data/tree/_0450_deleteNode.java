package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 11:09
 * @Description:
 */
public class _0450_deleteNode {

    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }

        return root;
    }

    // 练习
    class Solution {
        public TreeNode deleteNode(TreeNode root, int val) {
            if (root == null) {
                return null;
            }

            if (val < root.val) {
                root.left = deleteNode(root.left, val);
            } else if (root.val < val) {
                root.right = deleteNode(root.right, val);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode cur = root.right;
                    while (cur.left != null) {
                        cur = cur.left;
                    }
                    cur.left = root.left;
                    return root.right;
                }
            }
            return root;
        }
    }
}
