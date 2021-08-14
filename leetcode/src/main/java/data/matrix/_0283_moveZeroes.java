package data.matrix;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 11:05
 * @Description:
 */
public class _0283_moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        _0283_moveZeroes solution = new _0283_moveZeroes();
        solution.moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes1(int[] nums) {
        int index = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    // 左右指针
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int i = 0;
        for (int j = 0; j < N; j++) {
            if (nums[j] != 0) {
                swap(nums, i ,j);
                i++;
            }
        }
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
