package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-26 10:11
 * @Description:
 */
public class _1024_videoStitching {

    public static void main(String[] args) {
        int[][] clips = {
                {0,2}, {4,6}, {8,10},
                {1,9}, {1,5}, {5,9}
        };
        int T = 10;
        _1024_videoStitching solution = new _1024_videoStitching();

        System.out.println(solution.videoStitching(clips, T));
    }

    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
