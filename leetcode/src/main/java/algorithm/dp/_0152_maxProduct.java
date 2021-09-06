package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 05:50
 * @Description:
 */
public class _0152_maxProduct {


    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = max(nums[i], max * nums[i], min * nums[i]);
            int tempMin = min(nums[i], max * nums[i], min * nums[i]);
            max = tempMax;
            min = tempMin;
            res = Math.max(res, max);
        }
        return res;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
