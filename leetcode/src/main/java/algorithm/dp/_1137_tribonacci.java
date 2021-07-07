package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 16:08
 * @Description:
 */
public class _1137_tribonacci {

    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int p = 0;
        int q = 1;
        int r = 1;
        int s = 2;

        for (int i = 3; i < n; i++) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }

        return s;
    }
}
