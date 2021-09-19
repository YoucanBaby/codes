package even._061;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._061
 * @Author: xuyifang
 * @CreateTime: 2021-09-18 22:30
 * @Description:
 */
public class _05859_countKDifference {

    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) res++;
            }
        }
        return res;
    }
}
