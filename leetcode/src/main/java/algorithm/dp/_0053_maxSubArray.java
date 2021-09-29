package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-05 12:08
 * @Description:
 */
public class _0053_maxSubArray {

    public int maxSubArray(int[] nums) {
        int pre = (int) -1e9;
        int max = (int) -1e9;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }
}
