package algorithm.sort.base;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort.base
 * @Author: xuyifang
 * @CreateTime: 2021-08-08 03:57
 * @Description:
 */
public class Sort {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }

    public static void main(String[] args) {
        Sort sort = new Sort();

        int[] nums = {4,2,3,1,7,6,8,5,9,0};
        sort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        sort.selectionSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        sort.insertionSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        sort.shellSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        sort.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        sort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void bubbleSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public void selectionSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public void insertionSort(int[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 1 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public void shellSort(int[] nums) {
        int N = nums.length;

        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; 		// 1,4,13,40,121,364
        }

        while(h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    swap(nums, j, j -h);
                }
            }
            h = h / 3;
        }
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
        int p1 = left;
        int p2 = mid + 1;
        int i = left;
        int[] temp = new int[nums.length];

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
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

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 分区：左边区域比基数小，右边区域比基数大，然后返回基数的下标
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int p1 = left;
        int p2 = right;
        int pivot = nums[right];    // 选最后一位做为基准数
        while (p1 < p2) {
            while (p1 < p2 && nums[p1] <= pivot) {      // 先从左向右找大于基准的数
                p1++;
            }
            while (p1 < p2 && nums[p2] >= pivot) {      // 再从右向左找小于基准的数
                p2--;
            }
            swap(nums, p1, p2);     // 交换这这两个数
        }
        swap(nums, p1, right);      // 基准数归位，p1是基准数的位置
        return p1;
    }
}
