package algorithm.math;

import java.awt.geom.RectangularShape;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-29 14:48
 * @Description:
 */
public class _0039_majorityElement {

    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        return res;
    }
}
