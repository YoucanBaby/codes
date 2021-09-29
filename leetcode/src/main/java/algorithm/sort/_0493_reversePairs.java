package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 00:46
 * @Description:
 */
public class _0493_reversePairs {

    public static void main(String[] args) {
        // int[] nums = {2,4,3,5,1};
        int[] nums = {1,3,2,3,1};
        _0493_reversePairs solution = new _0493_reversePairs();

        System.out.println(solution.reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }

    int res = 0;
    int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if ((long) nums[l] > (long) nums[r] * 2) {
                res += mid - l + 1;
                r++;
            } else {
                l++;
            }
        }

        int p1 = left;
        int p2 = mid + 1;
        int i = left;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[i++] = nums[p1++];
            } else {
                temp[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = temp[j];
        }
    }

}
