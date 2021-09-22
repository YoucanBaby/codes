package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-09-20 14:38
 * @Description:
 */
public class _1894_chalkReplacer {


    public int chalkReplacer(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) sum += num;
        k %= sum;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) return i;
            k -= nums[i];
        }
        return -1;
    }

}
