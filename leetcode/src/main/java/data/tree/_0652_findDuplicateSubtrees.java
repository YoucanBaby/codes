package data.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree.nTree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 03:33
 * @Description:
 */
public class _0652_findDuplicateSubtrees {

    Map<String, Integer> freq = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);

        freq.put(serial, freq.getOrDefault(serial, 0) + 1);
        if (freq.get(serial) == 2) {
            res.add(root);
        }
        return serial;
    }
}
