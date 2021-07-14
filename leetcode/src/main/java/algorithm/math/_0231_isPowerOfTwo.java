package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 08:51
 * @Description:
 */
public class _0231_isPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        int N = 1 << 30;
        return (n > 0) && (N % n == 0);
    }
}
