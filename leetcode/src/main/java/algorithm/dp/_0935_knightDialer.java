package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-11 15:19
 * @Description:
 */
public class _0935_knightDialer {


    public int knightDialer(int n) {
        List<int[]> src = new ArrayList<>();
        src.add(new int[] {4, 6});
        src.add(new int[] {6, 8});
        src.add(new int[] {7, 9});
        src.add(new int[] {4, 8});
        src.add(new int[] {3, 9, 0});
        src.add(new int[] {});
        src.add(new int[] {1, 7, 0});
        src.add(new int[] {2, 6});
        src.add(new int[] {1, 3});
        src.add(new int[] {2, 4});

        int MOD = (int) (1e9 + 7);
        long[][] dp = new long[n][10];
        for (int i = 0; i < 10; i++) dp[0][i] = 1L;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k : src.get(j)) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        long res = 0;
        for (int j = 0; j < 10; j++) {
            res += dp[n - 1][j];
            res %= MOD;
        }
        return (int) res;
    }
}
