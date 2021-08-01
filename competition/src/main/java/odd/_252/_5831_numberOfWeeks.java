package odd._252;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._252
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 11:00
 * @Description:
 */
public class _5831_numberOfWeeks {

    public long numberOfWeeks(int[] nums) {
        long max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long rem = sum - max;

        if (rem >= max) {
            return sum;
        } else {
            return 2 * rem + 1;
        }
    }
}
