package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 19:59
 * @Description:
 */
public class _0213_rob {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        _0213_rob solution = new _0213_rob();

        System.out.println(solution.rob(nums));
    }


    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return nums[0];
        }

        int a = myRob(Arrays.copyOfRange(nums, 0, N - 1));
        int b = myRob(Arrays.copyOfRange(nums, 1, N));
        return Math.max(a, b);
    }

    public int myRob(int[] nums) {
        int N = nums.length;
        int pre = 0;
        int cur = nums[0];

        for (int i = 2; i <= N; i++) {
           int temp = Math.max(cur, pre + nums[i - 1]);
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
