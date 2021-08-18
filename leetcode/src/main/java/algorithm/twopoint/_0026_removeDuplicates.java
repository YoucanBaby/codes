package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 21:55
 * @Description:
 */
public class _0026_removeDuplicates {


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
