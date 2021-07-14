package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 08:57
 * @Description:
 */
public class _0342_isPowerOfFour {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public boolean isPowerOfFour1(int n) {
        return n > 0 && (1073741824 % n == 0) && n % 3 == 1;
    }
}
