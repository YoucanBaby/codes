package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 04:12
 * @Description:
 */
public class _1339_maxProduct {

    List<Long> sums = new ArrayList<>();
    int MOD = (int) (1e9 + 7);

    public int maxProduct(TreeNode root) {
        dfs(root);

        long res = 0;
        long allSum = sums.get(sums.size() - 1);
        for (long sum : sums) {
            res = Math.max(res, sum * (allSum - sum));
        }
        return (int) (res % MOD);
    }

    private long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long sum = root.val + dfs(root.left) + dfs(root.right);
        sums.add(sum);
        return sum;
    }
}
