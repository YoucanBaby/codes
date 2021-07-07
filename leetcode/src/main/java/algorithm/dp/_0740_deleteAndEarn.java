package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 21:03
 * @Description:
 */
public class _0740_deleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int[] sum = new int[maxValue + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        return rob(sum);
    }

    public int rob(int[] nums) {
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
