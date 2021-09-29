package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-22 10:19
 * @Description:
 */
public class _0976_largestPerimeter {

    public static void main(String[] args) {
        int[] nums = {3,6,2,3};
        _0976_largestPerimeter solution = new _0976_largestPerimeter();

        System.out.println(solution.largestPerimeter(nums));
    }


    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
