package algorithm.presum;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 04:45
 * @Description:
 */
public class _0050_myPow {

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

    public double myPow1(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            if (x == 1 || x == -1) {
                return 1;
            } else {
                return 0;
            }
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x = x * x;
            n = n >> 1;
        }
        return res;
    }
}
