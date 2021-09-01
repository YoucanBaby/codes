package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-08-16 06:46
 * @Description:
 */
public class _0526_countArrangement {

    int res = 0;

    public int countArrangement(int N) {
        boolean[] used = new boolean[N + 1];
        dfs(1, N, used);
        return res;
    }

    private void dfs(int index, int N, boolean[] used) {
        if (index == N + 1) {
            res++;
            return;
        }

        for (int num = 1; num <= N; num++) {      // 第i位上的数字
            if (used[num]) {
                continue;
            }
            if (num % index == 0 || index % num == 0) {
                used[num] = true;
                dfs(index + 1, N, used);
                used[num] = false;
            }
        }
    }
}
