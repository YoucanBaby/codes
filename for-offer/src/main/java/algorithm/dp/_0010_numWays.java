package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 13:25
 * @Description:
 */
public class _0010_numWays {

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int pre = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (pre + cur) % 1000000007;
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
