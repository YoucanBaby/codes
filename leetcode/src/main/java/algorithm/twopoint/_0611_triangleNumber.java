package algorithm.twopoint;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 19:40
 * @Description:
 */
public class _0611_triangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int res = 0;

        for (int i = N - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
