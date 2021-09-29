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

    public int videoStitching(int[][] clips, int N) {
        int[] nums = new int[N];
        for (int[] c : clips) {
            if (c[0] < N) {
                nums[c[0]] = Math.max(nums[c[0]], c[1]);
            }
        }

        int count = 0;
        int end = 0;
        int maxEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            maxEnd = Math.max(maxEnd, nums[i]);
            if (i == maxEnd) return -1;
            if (i == end) {
                count++;
                end = maxEnd;
            }
        }
        return count;
    }
}
