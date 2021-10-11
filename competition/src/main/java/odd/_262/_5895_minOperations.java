package odd._262;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._262
 * @Author: xuyifang
 * @CreateTime: 2021-10-10 10:36
 * @Description:
 */
public class _5895_minOperations {



    public int minOperations(int[][] mat, int x) {
        int M = mat.length, N = mat[0].length;
        int[] nums = new int[M * N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                nums[i * N + j] = mat[i][j];
            }
        }
        Arrays.sort(nums);
        for (int num : nums) {
            if ((num - nums[0]) % x != 0) return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (getCount(nums, mid, x) >= getCount(nums, mid + 1, x)) {
                left = mid + 1;
            } else if (getCount(nums, mid, x) < getCount(nums, mid + 1, x)) {
                right = mid;
            }
        }

        int min = getCount(nums, left, x);
        for (int i = nums[left] - x; i >= nums[0]; i -= x) {
            int count = getCount2(nums, i, x);
            if (count > min) {
                break;
            }
            min = count;
        }
        for (int i = nums[left] + x; i <= nums[nums.length - 1]; i += x) {
            int count = getCount2(nums, i, x);
            if (count > min) {
                break;
            }
            min = count;
        }
        return min;
    }

    private int getCount2(int[] nums, int target, int x) {
        int count = 0;
        for (int num : nums) {
            count += Math.abs(num - target) / x;
        }
        return count;
    }

    private int getCount(int[] nums, int mid, int x) {
        int count = 0;
        for (int num : nums) {
            count += Math.abs(num - nums[mid]) / x;
        }
        return count;
    }
}
