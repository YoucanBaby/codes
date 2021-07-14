package data.tree.nTree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree.nTree
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 22:58
 * @Description:
 */
public class _0559_maxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 1;
        for (Node node : root.children) {
            int depth = maxDepth(node) + 1;
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}
