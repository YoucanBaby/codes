package algorithm.twopoint;

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

        int left = N - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        int right = N - 1;
        if (left >= 0) {
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }
            swap(nums, left, right);
        }
        reverse(nums, left + 1, N - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
