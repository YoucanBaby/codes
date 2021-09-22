package algorithm.math;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 01:33
 * @Description:
 */
public class _0260_singleNumber {

    public static void main(String[] args) {
        _0260_singleNumber solution = new _0260_singleNumber();
        int[] nums = {1,2,1,3,2,5};

        System.out.println(Arrays.toString(solution.singleNumber(nums)));
    }

    public int[] singleNumber(int[] nums) {
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
