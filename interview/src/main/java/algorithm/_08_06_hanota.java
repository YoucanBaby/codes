package algorithm;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 06:24
 * @Description:
 */
public class _08_06_hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(0, A.remove(0));
            return;
        }

        move(n - 1, A, C, B);
        C.add(0, A.remove(0));
        move(n - 1, B, A, C);
    }
}
