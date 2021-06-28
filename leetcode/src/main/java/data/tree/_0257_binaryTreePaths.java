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

    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String s, List<String> paths) {
        if (root == null) {
            return;
        }

        StringBuilder path = new StringBuilder(s);
        path.append(root.val);

        if (root.left == null && root.right == null) {
            paths.add(path.toString());
        } else {
            path.append("->");
            constructPaths(root.left, path.toString(), paths);
            constructPaths(root.right, path.toString(), paths);
        }
    }
}
