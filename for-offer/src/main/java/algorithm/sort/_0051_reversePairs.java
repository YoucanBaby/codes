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

        System.out.println(solution.reversePairs1(nums));
        System.out.println(solution.reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }

    int cnt = 0;    // 用于计数

    public int reversePairs(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        mergeSort(nums, left, right);
        return cnt;
    }

    public void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) / 2;

        if (left < right) {
            // 左
            mergeSort(nums, left, mid);
            // 右
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid);
        } // 递归结束条件
    }

    public void merge(int[] nums, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;

        while (p1 <= mid && p2 <= right) {
            // 如果左边比右边小
            if (nums[p1] <= nums[p2]) {
                temp[i++] = nums[p1++];
            } else {
                // 如果右边比左边小
                temp[i++] = nums[p2++];
                // cnt就加上左边剩余元素的个数
                cnt += mid - p1 + 1;
            }
        }

        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }

        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }

        for (int j = 0; j < temp.length; j++) {
            nums[left + j] = temp[j];
        }
    }


    public int reversePairs1(int[] nums) {
        int N = nums.length;

        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
