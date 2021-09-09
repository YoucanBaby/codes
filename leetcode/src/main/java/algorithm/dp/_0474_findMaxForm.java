package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-30 00:04
 * @Description:
 */
public class _0474_findMaxForm {


    public int findMaxForm(String[] strs, int V, int M) {
        int N = strs.length;
        int[] zero = new int[N];
        int[] one = new int[N];
        for (int i = 0; i < N; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
                else if (c == '1') {
                    oneCount++;
                }
            }
            zero[i] = zeroCount;
            one[i] = oneCount;
        }

        int[][] dp = new int[V + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= zero[i]; j--) {
                for (int k = M; k >= one[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero[i]][k - one[i]] + 1);
                }
            }
        }
        return dp[V][M];
    }
}
