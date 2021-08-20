package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-19 21:44
 * @Description:
 */
public class _0080_removeDuplicates {


    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int left = 2;
        for (int right = 2; right < nums.length; right++) {
            if (nums[left - 2] == nums[right]) {
                continue;
            } else {
                nums[left++] = nums[right];
            }
        }
        return left;
    }
}
