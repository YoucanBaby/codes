package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 19:37
 * @Description:
 */
public class _0056_singleNumbers {



    public int[] singleNumbers(int[] nums) {
        int ab = 0;
        for (int num : nums) ab ^= num;
        int mask = ab & (-ab);
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
