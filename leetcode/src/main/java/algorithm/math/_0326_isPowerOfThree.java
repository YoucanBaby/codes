package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 08:27
 * @Description:
 */
public class _0326_isPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        return (n > 0) && (1162261467 % n == 0);
    }
}
