package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-20 14:11
 * @Description:
 */
public class _0051_reversePairs {

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        _0051_reversePairs solution = new _0051_reversePairs();

        System.out.println(solution.reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }

    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    public void merge(int[] nums, int left, int right, int mid) {
        int p1 = left;
        int p2 = mid + 1;
        int[] temp = new int[right - left + 1];
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[i++] = nums[p1++];
            } else {
                temp[i++] = nums[p2++];
                count += mid - p1 + 1;
            }
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = temp[j - left];
        }
    }
}
