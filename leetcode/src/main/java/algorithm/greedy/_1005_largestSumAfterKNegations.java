package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 19:45
 * @Description:
 */
public class _1005_largestSumAfterKNegations {


    public int largestSumAfterKNegations(int[] A, int k) {
        int N = A.length;
        Integer[] nums = new Integer[N];
        for (int i = 0; i < N; i++) {
            nums[i] = A[i];     // 自动装箱
        }
        // 逆序排序
        Arrays.sort(nums, (o1, o2) -> Math.abs(o2) - Math.abs(o1));

        for (int i = 0; i < N; i++) {
            if (k <= 0) {
                break;
            }
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k % 2 == 1) {
            nums[N - 1] = -nums[N - 1];
        }

        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
