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
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int area = Math.min(nums[left], nums[right]) * (right - left);
            res = Math.max(res, area);
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
