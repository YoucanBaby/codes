package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 19:16
 * @Description:
 */
public class _0089_grayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int N = 1 << n;
        for (int i = 0; i < N; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
