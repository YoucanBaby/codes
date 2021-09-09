package algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-10 02:27
 * @Description:
 */
public class _0446_numberOfArithmeticSlices {

    public static void main(String[] args) {
        _0446_numberOfArithmeticSlices solution = new _0446_numberOfArithmeticSlices();
        int[] nums = {0,2000000000,-294967296};
        System.out.println(solution.numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int N = nums.length;
        if (N < 3) {
            return 0;
        }

        Map<Long, Integer>[] dp = new HashMap[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new HashMap<>();
        }

        int res = 0;
        for (int right = 1; right < N; right++) {
            for (int left = 0; left < right; left++) {
                long diff = (long) nums[right] - nums[left];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                // dp[right][diff] += dp[left][diff] + 1;
                dp[right].put(diff, dp[right].getOrDefault(diff, 0) + dp[left].getOrDefault(diff, 0) + 1);
                if (dp[left].containsKey(diff)) {
                    res += dp[left].get(diff);
                }
            }
        }
        return res;
    }
}
