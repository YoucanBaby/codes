package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 06:25
 * @Description:
 */
public class _0280_wiggleSort {


    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (((i & 1) == 0 && nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
            if (((i & 1) == 1 && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
