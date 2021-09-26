package odd._260;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._260
 * @Author: xuyifang
 * @CreateTime: 2021-09-26 10:30
 * @Description:
 */
public class _5881_maximumDifference {


    public int maximumDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, nums[j] - nums[i]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
