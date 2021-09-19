package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-17 16:03
 * @Description:
 */
public class _0191_hammingWeight {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
