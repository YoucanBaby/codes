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

    public static void main(String[] args) {
        test test = new test();

        int[] nums = {2,4,9,0,1,3,5,7,6,8};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums) + "  api");
        Shuffle s = new Shuffle(nums);
        s.shuffle();

        test.bubbleSort(nums);
        System.out.println(Arrays.toString(nums) + "  bubble");
        s.shuffle();

        test.selectionSort(nums);
        System.out.println(Arrays.toString(nums) + "  selection");
        s.shuffle();

        test.insertionSort(nums);
        System.out.println(Arrays.toString(nums) + "  insertion");
        s.shuffle();
    }

    public void insertionSort(int[] nums) {
        for (int j = 1; j < nums.length; j++) {
            for (int i = j; i >= 1; i--) {
                if (nums[i - 1] < nums[i]) {
                    break;
                }
                swap(nums, i - 1, i);
            }
        }
    }

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            swap(nums, i, min);
        }
    }

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
