package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-07-11 14:18
 * @Description:
 */
public class _0274_hIndex {


    public int hIndex(int[] citations) {
        int N = citations.length;
        int[] freq = new int[N + 1];
        for (int c : citations) {
            if (c >= N) freq[N]++;
            else freq[c]++;
        }
        int sum = 0;
        for (int h = N; h >= 0; h--) {
            sum += freq[h];
            if (sum >= h) return h;
        }
        return 0;
    }
}
