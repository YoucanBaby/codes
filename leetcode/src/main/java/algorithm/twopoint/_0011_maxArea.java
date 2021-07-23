package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 18:24
 * @Description:
 */
public class _0011_maxArea {


    public int maxArea(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        int res = 0;

        while (L < R) {
            int area = Math.min(nums[L], nums[R]) * (R - L);
            res = Math.max(res, area);

            if (nums[L] < nums[R]) {
                L++;
            } else {
                R--;
            }
        }

        return res;
    }
}
