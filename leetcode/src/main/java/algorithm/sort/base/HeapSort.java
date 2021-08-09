package algorithm.sort.base;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort.base
 * @Author: xuyifang
 * @CreateTime: 2021-08-08 04:43
 * @Description:
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort solution = new HeapSort();

        int[] nums = {Integer.MAX_VALUE,4,2,3,1,7,6,8,5,9,0};
        solution.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void heapSort(int[] nums) {
        int N = nums.length - 1;            // 数组范围是[1, N]
        for (int k = N / 2; k >= 1; k--)    // 下沉所有的非叶子节点
            sink(nums, k, N);

        while (N >= 1) {
            swap(nums, 1, N--);         // 交换第一个节点和最大的节点
            sink(nums, 1, N);          // 交换之后需要进行下沉操作维持堆的有序状态
        }
    }

    private void sink(int[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N && nums[j] < nums[j + 1])
                j++;
            if (nums[k] > nums[j])
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
