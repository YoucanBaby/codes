package algorithm.math;

import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-10-10 09:07
 * @Description:
 */
public class _0441_arrangeCoins {


    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt((long) 8 * n + 1)) / 2);
    }
}
