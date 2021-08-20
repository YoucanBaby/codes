package algorithm.twopoint;

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
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }
}
