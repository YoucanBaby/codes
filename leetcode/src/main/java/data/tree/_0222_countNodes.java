package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 10:45
 * @Description:
 */
public class _0222_countNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);        // 左/右子树深度
        int rightDepth = maxDepth(root.right);

        int leftCount = 0;
        int rightCount = 0;
        if (leftDepth == rightDepth) {
            leftCount = 1 << leftDepth;              // 左子树节点个数 + 根节点
            rightCount = countNodes(root.right);     // 右子树节点个数
        } else if (leftDepth > rightDepth) {
            leftCount = countNodes(root.left);       // 左子树节点个数
            rightCount = 1 << rightDepth;            // 右子树节点个数 + 根节点
        }

        return leftCount + rightCount;
    }

    // 计算子树的深度
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            int leftCount = 0;
            int rightCount = 0;
            if (leftDepth == rightDepth) {
                leftCount = 1 << leftDepth;
                rightCount = countNodes(root.right);
            } else if (leftDepth > rightDepth) {
                leftCount = countNodes(root.left);
                rightCount = 1 << rightDepth;
            }

            return leftCount + rightCount;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
