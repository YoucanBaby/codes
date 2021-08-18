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

    int i = 1;          // 第i位
    int res = 0;

    public int countArrangement(int N) {
        boolean[] used = new boolean[N + 1];
        dfs(used, N);
        return res;
    }

    private void dfs(boolean[] used, int N) {
        if (i == N + 1) {
            res++;
            return;
        }
        for (int num = 1; num <= N; num++) {      // 第i位上的数字
            if (used[num]) {
                continue;
            }
            if (num % i == 0 || i % num == 0) {
                i++;
                used[num] = true;
                dfs(used, N);
                used[num] = false;
                i--;
            }
        }
    }
}
