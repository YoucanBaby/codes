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

    public int hIndex1(int[] citations) {
        Arrays.sort(citations);

        int N = citations.length;
        int h = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (citations[i] <= h) {
                return h;
            }
            h++;
        }

        return N;
    }


    public int hIndex2(int[] citations) {
        int N = citations.length;
        int[] count = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (citations[i] >= N) {
                count[N]++;
            } else {
                count[citations[i]]++;
            }
        }

        int sum = 0;
        for (int i = N; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
