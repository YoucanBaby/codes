package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 00:59
 * @Description:
 */
public class _1588_sumOddLengthSubarrays {


    public int sumOddLengthSubarrays(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - i;
            int leftOdd = left / 2;
            int rightOdd = right / 2;
            int leftEven = (left + 1) / 2;
            int rightEven = (right + 1) / 2;

            res += (leftOdd * rightOdd + leftEven * rightEven) * nums[i];
        }
        return res;
    }
}
