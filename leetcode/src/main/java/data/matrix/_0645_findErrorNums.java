package data.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 18:04
 * @Description:
 */
public class _0645_findErrorNums {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,6};
        _0645_findErrorNums solution = new _0645_findErrorNums();

        int[] nums1 = solution.findErrorNums(nums);
        System.out.println(Arrays.toString(nums1));
    }

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] >= 0) {
                nums[Math.abs(num) - 1] *= -1;
            } else {
                res[0] = Math.abs(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }



}
