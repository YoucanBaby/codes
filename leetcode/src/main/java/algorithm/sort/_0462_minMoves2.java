package algorithm.sort;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 09:47
 * @Description:
 */
public class _0462_minMoves2 {

    public int minMoves2(int[] nums) {
        int median = quickSort(nums, nums.length / 2, 0, nums.length - 1);
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
    }

    public int quickSort(int[] nums, int k, int left, int right) {
        int mid = partition(nums, left, right);
        if (mid == k) {
            return nums[mid];
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