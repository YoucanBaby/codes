package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-30 00:04
 * @Description:
 */
public class _0474_findMaxForm {


    public int findMaxForm(String[] strs, int M, int N) {
        int[][] dp = new int[M + 1][N + 1];
        for (String str : strs) {
            int zeroNum = 0;        // 0个数
            int oneNum = 0;         // 1个数
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int i = M; i >= zeroNum; i--) {
                for (int j = N; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[M][N];
    }
}
