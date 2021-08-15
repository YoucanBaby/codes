package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 08:37
 * @Description:
 */
public class _1004_longestOnes {


    public int longestOnes(int[] nums, int K) {
        int res = 0;
        int zeroNum = 0;        // 0的个数
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroNum++;
            }
            while (zeroNum > K) {
                if (nums[left] == 0) {
                    zeroNum--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
