package data.matrix;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 00:00
 * @Description:
 */
public class _0031_nextPermutation {

    public static void main(String[] args) {
        int[] nums = {4,5,3,6,2,1};
        _0031_nextPermutation solution = new _0031_nextPermutation();
        solution.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int N = nums.length;

        // 从后向前找第一个顺序对（i，i+1），使得nums[i]<nums[i+1]
        int i = N - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 从后向前找 nums[i] < nums[j]
        int j = N - 1;
        if (i >= 0) {
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换 nums[i] 与 nums[j]
            swap(nums, i, j);
        }
        // 反转区间 [i+1,n)
        reverse(nums, i + 1, N - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
