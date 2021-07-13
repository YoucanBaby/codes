package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 18:20
 * @Description:
 */
public class _0016_myPow {

    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            if (x == 1 || x == -1) {
                return 1;
            } else {
                return 0;
            }
        }
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return myPow(1 / x, -n);
        } else if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x, n - 1);
        }
    }

}
