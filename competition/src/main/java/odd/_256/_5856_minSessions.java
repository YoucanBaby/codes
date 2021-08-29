package odd._256;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._256
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 10:58
 * @Description:
 */
public class _5856_minSessions {

    public static void main(String[] args) {
        _5856_minSessions solution = new _5856_minSessions();

        int[] tasks = {2,3,3,4,4,4,6,7,8,9,10};
        int sessionTime = 15;
        System.out.println(solution.minSessions(tasks, sessionTime));
    }

    public int minSessions(int[] tasks, int sessionTime) {
        int N = tasks.length;
        int[] sum = new int[1 << N];
        for (int i = 1; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    sum[i] = sum[i ^ (1 << j)] + tasks[j];
                    break;
                }
            }
        }

        int[] dp = new int[1 << N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < (1 << N); i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (sum[j] > sessionTime) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
            }
        }
        return dp[(1 << N) - 1];
    }
}
