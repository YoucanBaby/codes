package algorithm.twopoint;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 22:30
 * @Description:
 */
public class _0016_threeSumClosest {

    public static void main(String[] args) {
        _0016_threeSumClosest solution = new _0016_threeSumClosest();
        int[] nums = {0,2,1,-3};
        int target = 1;

        System.out.println(solution.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int res = (int) 1e8;

        for (int k = 0; k < N - 2; k++) {
            int left = k + 1;
            int right = N - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (Math.abs(res - target) > Math.abs(sum - target)) {
                    res = sum;
                }
                if (sum - target < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
