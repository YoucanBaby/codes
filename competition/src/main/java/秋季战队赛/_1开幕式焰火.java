package 秋季战队赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: 秋季战队赛
 * @Author: xuyifang
 * @CreateTime: 2021-09-25 15:02
 * @Description:
 */
public class _1开幕式焰火 {

    Map<Integer, Integer> map = new HashMap<>();

    public int numColor(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        int res = 0;
        for (int val : map.values()) res++;
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left);
        dfs(root.right);
    }
}
