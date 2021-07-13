package algorithm.sort.base;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort.base
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 10:36
 * @Description:
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {101,51,7,98,154,23,4};
        MergeSort solution = new MergeSort();
        solution.mergeSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        // 往下取整，mid落在左边最后一个位置上
        int mid = (left + right) / 2;
        // 递归左边数组
        mergeSort(nums, left, mid);
        // 递归右边数组
        mergeSort(nums, mid + 1, right);
        // 归并排序当前数组
        merge(nums, left, right, mid);
    }

    public void merge(int[] nums, int left, int right, int mid) {
        // 用于存储归并后数据的临时数组
        int[] temp = new int[right - left + 1];

        // 用于记录左边数组中需要遍历的下标
        int p1 = left;
        // 记用于录右边数组中需要遍历的下标
        int p2 = mid + 1;
        // 记用于录临时数组中的下标
        int i = 0;

        // 遍历两个数组，取出小的数组放入临时数组中
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
                // 如果左边数组的的数据更小，则把小的数据放入临时数组中
                temp[i++] = nums[p1++];
            } else {
                // 如果右边数组的的数据更小，把小的数据放入临时数组中
                temp[i++] = nums[p2++];
            }
        }
        // 处理左边数组中多余的数据
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        // 处理右边数组中多余的数据
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }
        // 把临时数组中的数据存入原数组
        for (i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}
