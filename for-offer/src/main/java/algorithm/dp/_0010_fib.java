package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 13:18
 * @Description:
 */
public class _0010_fib {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        int cur = 1;

        for (int i = 2; i <= n; i++) {
            int temp = (pre + cur) % 1000000007;
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
