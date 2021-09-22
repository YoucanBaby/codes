package data.matrix;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: com.yifang
 * @Author: xuyifang
 * @CreateTime: 2021-06-10 20:00
 * @Description:
 */
public class _0003_findRepeatNumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 1, 3};
        _0003_findRepeatNumber solution = new _0003_findRepeatNumber();
        System.out.println(solution.findRepeatNumber(arr));
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }


    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return nums[i];
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
