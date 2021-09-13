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
        int[] right = new int[T];
        for (int[] c : clips) {
            if (c[0] < T) {
                right[c[0]] = Math.max(right[c[0]], c[1]);
            }
        }

        int maxEnd = 0;     // 左端点在上一个区间内能覆盖到的最远的右端点
        int end = 0;        // 上一个区间的结束位置
        int res = 0;
        for (int i = 0; i < right.length; i++) {
            maxEnd = Math.max(maxEnd, right[i]);
            if (i >= maxEnd) {
                return -1;
            }
            if (i == end) {
                end = maxEnd;
                res++;
            }
        }
        return res;
    }
}
