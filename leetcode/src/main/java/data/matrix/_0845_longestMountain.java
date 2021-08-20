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
        int index = 1;
        while (index < N) {
            int increasing = 0;
            int decreasing = 0;
            while (index < N && nums[index - 1] < nums[index]) {
                increasing++;
                index++;
            }
            while (index < N && nums[index - 1] > nums[index]) {
                decreasing++;
                index++;
            }
            if (increasing > 0 && decreasing > 0) {
                res = Math.max(res, increasing + decreasing + 1);
            }

            while (index < N && nums[index - 1] == nums[index]) {       // 跳过所有平地
                index++;
            }
        }
        return res;
    }
}
