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
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > end) {
                return false;
            } else {
                end = Math.max(end, i + nums[i]);
            }
        }
        return true;
    }
}
