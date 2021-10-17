package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 14:28
 * @Description:
 */
public class _0029_divide {

    public static void main(String[] args) {
        _0029_divide solution = new _0029_divide();
        System.out.println(solution.divide(21, 2));
    }

    public int divide(int a, int b) {
        boolean isMinus = false;
        if ((a ^ b) < 0) isMinus = true;

        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        List<Long> list = new ArrayList<>();
        for (long z = y; z <= x; z *= 2) list.add(z);

        long res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (x >= list.get(i)) {
                x -= list.get(i);
                res += 1L << i;
            }
        }
        if (isMinus) res = -res;

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            res = Integer.MAX_VALUE;
        }
        return (int) res;
    }
}
