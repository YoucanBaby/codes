package algorithm.twopoints;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoints
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 00:40
 * @Description:
 */
public class _0057_twoSum {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] {nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }
}
