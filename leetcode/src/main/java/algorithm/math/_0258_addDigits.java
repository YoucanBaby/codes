package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 13:08
 * @Description:
 */
public class _0258_addDigits {


    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
