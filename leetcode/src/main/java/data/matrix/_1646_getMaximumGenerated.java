package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 00:50
 * @Description:
 */
public class _1646_getMaximumGenerated {


    public int getMaximumGenerated(int N) {
        if (N == 0 || N == 1) {
            return N;
        }

        int max = 0;
        int[] nums = new int[N + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= N; i++) {
            if ((i & 1) == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
