package algorithm.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-09-14 06:44
 * @Description:
 */
public class _1262_maxSumDivThree {

    public static void main(String[] args) {
        _1262_maxSumDivThree solution = new _1262_maxSumDivThree();
        int[] nums = {3,6,5,1,8};
        System.out.println(solution.maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {
        int[] remainder = {0,0,0};
        for (int num : nums) {
            int a = remainder[0] + num;
            int b = remainder[1] + num;
            int c = remainder[2] + num;
            remainder[a % 3] = Math.max(remainder[a % 3], a);
            remainder[b % 3] = Math.max(remainder[b % 3], b);
            remainder[c % 3] = Math.max(remainder[c % 3], c);
        }
        return remainder[0];
    }
}
