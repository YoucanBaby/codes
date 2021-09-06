package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-06 18:00
 * @Description:
 */
public class _0887_superEggDrop {

    public static void main(String[] args) {
        _0887_superEggDrop solution = new _0887_superEggDrop();
        System.out.println(solution.superEggDrop1(1, 2));
    }

    // N个鸡蛋，M层楼
    public int superEggDrop(int N, int M) {
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + 1;
                if (dp[i][N] >= M) {
                    return i;
                }
            }
        }
        return 0;
    }

    // N个鸡蛋，M层楼
    public int superEggDrop1(int N, int M) {
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            dp[i][1] = i;
        }
        for (int j = 1; j <= N; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= M; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = i;
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - k][j], dp[k - 1][j - 1]) + 1);
                }
            }
        }
        return dp[M][N];
    }
}
