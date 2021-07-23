package algorithm.math;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-23 00:38
 * @Description:
 */
public class _1893_isCovered {


    public static void main(String[] args) {
        int[][] ranges = {
                {1,2}, {4,6}
        };
        int left = 2;
        int right = 5;
        _1893_isCovered solution = new _1893_isCovered();

        System.out.println(solution.isCovered(ranges, left, right));
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }

        int cur = 0;
        for (int i = 1; i <= 50; i++) {
            cur += diff[i];
            if (left <= i && i <= right && cur == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isCovered1(int[][] ranges, int left, int right) {
        boolean[] flags = new boolean[51];
        for (int[] range : ranges) {
            Arrays.fill(flags, range[0], range[1] + 1, true);
        }
        for (int i = left; i <= right; i++) {
            if (flags[i] == false) {
                return false;
            }
        }
        return true;
    }
}
