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
        int count = 0;
        int end = 0;
        int maxEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxEnd = Math.max(maxEnd, i + nums[i]);
            if (i == end) {
                count++;
                end = maxEnd;
            }
        }
        return count;
    }
}
