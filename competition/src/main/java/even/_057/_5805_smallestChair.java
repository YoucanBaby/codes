package even._057;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._057
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 22:40
 * @Description:
 */
public class _5805_smallestChair {


    public int smallestChair(int[][] times, int targetFriend) {
        // 目标朋友的值
        int[] targetFriendVal = times[targetFriend];
        // 按到达时刻升序排序
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);

        int[] chairs = new int[times.length];
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];

            for (int j = 0; j < chairs.length; j++) {
                if (chairs[j] <= time[0]) {
                    chairs[j] = time[1];
                    if (time[0] == targetFriendVal[0] && time[1] == targetFriendVal[1]) {
                        return j;
                    }
                    break;
                }
            }
        }
        return -1;
    }
}
