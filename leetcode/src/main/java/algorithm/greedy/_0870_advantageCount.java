package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 06:55
 * @Description:
 */
public class _0870_advantageCount {

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int N = B.length;
        int[][] sortB = new int[N][2];
        for (int i = 0; i < N; i++) {
            sortB[i][0] = B[i];
            sortB[i][1] = i;
        }
        Arrays.sort(sortB, (o1, o2) -> o1[0]- o2[0]);

        int[] res = new int[N];
        int left = 0;
        int right = N - 1;
        // A中当前的马 比 B中最小马小，就和 B的最大马 赛马。
        for (int i = 0; i < N; i++) {
            if (A[i] > sortB[left][0]) {
                int index = sortB[left][1];
                res[index] = A[i];
                left++;
            } else {
                int index = sortB[right][1];
                res[index] = A[i];
                right--;
            }
        }
        return res;
    }
}
