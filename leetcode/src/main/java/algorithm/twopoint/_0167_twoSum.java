package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 14:13
 * @Description:
 */
public class _0167_twoSum {

    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] {left + 1, right + 1};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }
}
