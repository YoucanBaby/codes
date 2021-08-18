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
        int[] nums = {200,5,10,15,40,32,100};
        int K = 2;

        System.out.println(Arrays.toString(test.solution(nums, K)));
    }

    public int[] solution(int[] nums, int K) {
        quickSort(nums, 0, nums.length - 1, K);
        return Arrays.copyOfRange(nums, nums.length - K, nums.length);
    }

    private void quickSort(int[] nums, int left, int right, int K) {
        int mid = patition(nums, left, right);
        if (mid == nums.length - K) {
            return;
        } else if (mid > nums.length - K) {
            quickSort(nums, 0, mid, K);
        } else {
            quickSort(nums, mid + 1, right, K);
        }
    }

    private int patition(int[] nums, int left, int right) {
        int p1 = left;
        int p2 = right;
        int pivot = nums[right];
        while (p1 < p2) {
            while (p1 < p2 && nums[p1] < pivot) {
                p1++;
            }
            while (p1 < p2 && nums[p2] > pivot) {
                p2--;
            }
            swap(nums, p1, p2);
        }
        swap(nums, p1, right);
        return p1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
