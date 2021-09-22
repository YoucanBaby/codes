package algorithm;

import java.util.HashSet;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-09-21 17:43
 * @Description:
 */
public class _16_14_bestLine {



    public int[] bestLine(int[][] p) {
        int N = p.length;
        int[] res = new int[2];
        int max = -1;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int count = 0;
                long dx1 = p[j][0] - p[i][0];
                long dy1 = p[j][1] - p[i][1];
                for (int k = j + 1; k < N; k++) {
                    long dx2 = p[k][0] - p[j][0];
                    long dy2 = p[k][1] - p[j][1];
                    if (dx1 * dy2 == dx2 * dy1) count++;
                }
                if (count > max) {
                    max = count;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
