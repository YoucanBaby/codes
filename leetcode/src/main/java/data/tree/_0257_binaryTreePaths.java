package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 19:54
 * @Description:
 */
public class _0257_binaryTreePaths {



    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPaths(root, res, "");
        return res;
    }

    public void constructPaths(TreeNode root, List<String> res, String path) {
        if (root == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            constructPaths(root.left, res, sb.toString());
            constructPaths(root.right, res, sb.toString());
        }
    }
}
