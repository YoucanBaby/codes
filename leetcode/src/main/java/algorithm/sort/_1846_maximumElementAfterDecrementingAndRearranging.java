package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-07-15 00:49
 * @Description:
 */
public class _1846_maximumElementAfterDecrementingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging1(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public int maximumElementAfterDecrementingAndRearranging2(int[] nums) {
        int N = nums.length;
        int[] count = new int[N + 1];
        for (int num : nums) {
            if (num >= N) {
                count[N]++;
            } else {
                count[num]++;
            }
        }

        int res = 1;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res + count[i], i);
        }
        return res;
    }
}
