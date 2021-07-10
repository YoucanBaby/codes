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
        int N = nums.length;
        int[] max = new int[N];
        int[] min = new int[N];
        int res = nums[0];

        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < N; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
            res = Math.max(res, max[i]);
        }

        return res;
    }

    // 空间优化
    public int maxProduct1(int[] nums) {
        int N = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < N; i++) {
            int tempMax = max;
            int tempMin = min;
            max = Math.max(tempMax * nums[i], Math.max(tempMin * nums[i], nums[i]));
            min = Math.min(tempMax * nums[i], Math.min(tempMin * nums[i], nums[i]));
            res = Math.max(res, max);
        }

        return res;
    }
}
