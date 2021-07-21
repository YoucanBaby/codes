package algorithm.greedy;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 23:34
 * @Description:
 */
public class _0135_candy {

    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] left = new int[N];
        int[] right = new int[N];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 左规则
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 右规则
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}
