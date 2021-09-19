package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 18:05
 * @Description:
 */
public class _0845_longestMountain {


    public int longestMountain(int[] nums) {
        int N = nums.length;
        int res = 0;
        int i = 1;
        while (i < N) {
            int inc = 0;
            int dec = 0;
            while (i < N && nums[i] > nums[i - 1]) {
                inc++;
                i++;
            }
            while (i < N && nums[i] < nums[i - 1]) {
                dec++;
                i++;
            }
            if (inc > 0 && dec > 0) {
                res = Math.max(res, inc + dec + 1);
            }

            while (i < N && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return res;
    }
}
