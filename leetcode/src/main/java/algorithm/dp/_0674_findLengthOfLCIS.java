package algorithm.dp;

import java.util.logging.Level;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-02 03:47
 * @Description:
 */
public class _0674_findLengthOfLCIS {


    public int findLengthOfLCIS(int[] nums) {
        int cur = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        return Math.max(max, cur);
    }
}
