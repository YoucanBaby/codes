package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 15:29
 * @Description:
 */
public class _0045_jump {

    public int jump(int[] nums) {
        int end = 0;
        int res = 0;
        int maxEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 找跳得最远的位置
            maxEnd = Math.max(maxEnd, nums[i] + i);
            // 遇到边界，更新边界，并且结果+1
            if (i == end) {
                end = maxEnd;
                res++;
            }
        }
        return res;
    }
}
