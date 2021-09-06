package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-06 07:16
 * @Description:
 */
public class _1567_getMaxLen {


    public int getMaxLen(int[] nums) {
        int p = nums[0] > 0 ? 1 : 0;
        int n = nums[0] < 0 ? 1 : 0;
        int res = p;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                p = p + 1;
                n = n > 0 ? n + 1 : 0;
            } else if (nums[i] < 0) {
                int tempP = n > 0 ? n + 1 : 0;
                int tempN = p + 1;
                p = tempP;
                n = tempN;
            } else {
                p = 0;
                n = 0;
            }
            res = Math.max(res, p);
        }
        return res;
    }
}
