package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-22 21:56
 * @Description:
 */
public class _0137_singleNumber {


    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos =  twos ^ num & ~ones;
        }
        return ones;
    }
}
