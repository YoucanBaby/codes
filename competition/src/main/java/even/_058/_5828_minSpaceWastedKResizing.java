package even._058;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._058
 * @Author: xuyifang
 * @CreateTime: 2021-08-07 23:05
 * @Description:
 */
public class _5828_minSpaceWastedKResizing {

    public static void main(String[] args) {
        int[] nums = {10,20,15,30,20};
        int k = 2;
        _5828_minSpaceWastedKResizing solution = new _5828_minSpaceWastedKResizing();

        System.out.println(solution.minSpaceWastedKResizing(nums, k));
    }

    public int minSpaceWastedKResizing(int[] nums, int K) {
        int N = nums.length;
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], (int) (1e9 + 7));
        }
        dp[0][0] = 0;

        int high = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            high = Math.max(high, nums[i]);
            sum += nums[i];
            dp[i + 1][0] = high * (i + 1) - sum;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < K; ++j) {
                high = 0;
                sum = 0;
                for (int next = i + 1; next <= N; next++) {
                    high = Math.max(high, nums[next - 1]);
                    sum += nums[next - 1];
                    dp[next][j + 1] = Math.min(dp[next][j + 1], dp[i][j] + high * (next - i) - sum);
                }
            }
        }
        return dp[N][K];
    }


}
