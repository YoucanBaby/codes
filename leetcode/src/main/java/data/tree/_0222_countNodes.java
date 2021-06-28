package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 10:45
 * @Description:
 */
public class _0222_countNodes {

    public int countNodes1(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }

        // 递归左子树
        int leftNode = countNodes1(root.left);
        // 递归右子树
        int rightNode = countNodes1(root.right);

        // 返回值
        return leftNode + rightNode + 1;
    }


    public int countNodes(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        // 左/右子树深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int leftNode = 0;
        int rightNode = 0;
        if (leftDepth == rightDepth) {
            // 左子树节点个数 + 根节点
            leftNode = 1 << leftDepth;
            // 递归右子树
            rightNode = countNodes(root.right);
        } else if (leftDepth > rightDepth) {
            // 递归左子树
            leftNode = countNodes(root.left);
            // 右子树节点个数 + 根节点
            rightNode = 1 << rightDepth;
        }

        // 返回值
        return leftNode + rightNode;
    }

    public int maxDepth(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        // 递归左子树
        int leftDepth = maxDepth(root.left);
        // 递归右子树
        int rightDepth = maxDepth(root.right);
        // 返回值
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
