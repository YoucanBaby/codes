package algorithm.twopoint;

import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 15:49
 * @Description:
 */
public class _0977_sortedSquares {

    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int index = N - 1;
        int[] res = new int[N];

        int left = 0;
        int right = N - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index] = (int) Math.pow(nums[right], 2);
                index--;
                right--;
            } else {
                res[index] = (int) Math.pow(nums[left], 2);
                index--;
                left++;
            }
        }
        return res;
    }
}
