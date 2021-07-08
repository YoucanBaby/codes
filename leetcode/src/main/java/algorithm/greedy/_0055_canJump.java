package algorithm.greedy;

import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 14:42
 * @Description:
 */
public class _0055_canJump {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            } else {
                max = Math.max(max, i + nums[i]);
            }
        }
        return true;
    }
}
