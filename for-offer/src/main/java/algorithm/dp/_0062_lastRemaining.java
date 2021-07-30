package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 17:18
 * @Description:
 */
public class _0062_lastRemaining {

    // 动态规划
    public int lastRemaining2(int n, int m) {
        int dp = 0;
        for (int i = 2; i <= n; i++) {
            dp = (dp + m) % i;
        }
        return dp;
    }
}
