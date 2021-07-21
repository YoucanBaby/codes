package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 18:58
 * @Description:
 */
public class _0376_wiggleMaxLength {

    // 动态规划
    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    // 贪心
    public int wiggleMaxLength1(int[] nums) {
        int preDiff = 0;    // 前一组差值
        int curDiff = 0;    // 当前一组差值
        int res = 1;        // 两个端点，只有一个峰，所以要+1
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            // 出现山峰
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}
