package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: interview
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 03:45
 * @Description:
 */
public class _17_14_smallestK {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        _17_14_smallestK solution = new _17_14_smallestK();

        System.out.println(Arrays.toString(solution.smallestK1(arr, k)));
        System.out.println(Arrays.toString(solution.smallestK(arr, k)));
    }

    public int[] smallestK1(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }

    public int[] smallestK(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        return quickSort(nums, k - 1, 0, nums.length - 1);
    }

    public int[] quickSort(int[] nums, int k, int left, int right) {
        int mid = partition(nums, left, right);
        if (mid == k) {
            return Arrays.copyOfRange(nums, 0, k + 1);
        } else if (mid < k) {
            return quickSort(nums, k, mid + 1, right);
        } else {
            return quickSort(nums, k, left, mid - 1);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int p1 = left;
        int p2 = right;
        int pivot = nums[right];
        while (p1 < p2) {
            while (p1 < p2 && nums[p1] <= pivot) {
                p1++;
            }
            while (p1 < p2 && nums[p2] >= pivot) {
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
