package algorithm.presum;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-09-17 12:15
 * @Description:
 */
public class _0238_productExceptSelf {

    public static void main(String[] args) {
        _0238_productExceptSelf solution = new _0238_productExceptSelf();

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, 1);

        int p = 1;
        for (int i = 1; i < N; i++) {
            p *= nums[i - 1];
            res[i] *= p;
        }

        int q = 1;
        for (int i = N - 2; i >= 0; i--) {
            q *= nums[i + 1];
            res[i] *= q;
        }
        return res;
    }
}
