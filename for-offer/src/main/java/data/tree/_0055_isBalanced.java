package data.tree;

import javafx.scene.transform.Rotate;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-27 20:14
 * @Description:
 */
public class _0055_isBalanced {


    public static void main(String[] args) {

    }


    public boolean isBalanced(TreeNode root) {
        return recur(root) == -1 ? false : true;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = recur(root.left);
        if (leftDepth == -1) {
            return -1;
        }

        int rightDepth = recur(root.right);
        if (rightDepth == -1) {
            return -1;
        }


        if (Math.abs(rightDepth - leftDepth) <= 1) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            return -1;
        }
    }
}
