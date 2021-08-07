import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:30
 * @Description:
 */

public class test {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }

    public static void main(String[] args) {
        test test = new test();

        int[] nums = {4,2,3,1,7,6,8,5,9,0};
        test.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        test.selectionSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        test.insertionSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,3,1,7,6,8,5,9,0};
        test.shellSort(nums);
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


}
