package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 07:23
 * @Description:
 */
public class _0334_increasingTriplet {


    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int num : nums) {
            if (small >= num) {
                small = num;
            } else if (mid >= num) {
                mid = num;
            } else if (mid < num) {
                return true;
            }
        }
        return false;
    }
}
