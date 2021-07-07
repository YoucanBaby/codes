package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 15:59
 * @Description:
 */
public class _0509_fib {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }


    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }


}
