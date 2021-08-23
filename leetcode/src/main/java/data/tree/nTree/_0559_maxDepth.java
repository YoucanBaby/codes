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

        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}
