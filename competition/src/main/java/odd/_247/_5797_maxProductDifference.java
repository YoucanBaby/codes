package odd._247;

import java.util.Arrays;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-27 10:42
 * @Description:
 */
public class _5797_maxProductDifference {

    public static void main(String[] args) {

    }

    public int maxProductDifference(int[] nums) {

        int N = nums.length;
        Arrays.sort(nums);

        return nums[N - 1] * nums[N - 2] - nums[0] * nums[1];
    }
}
