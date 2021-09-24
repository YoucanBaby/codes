package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-24 09:27
 * @Description:
 */
public class _0836_isRectangleOverlap {


    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long x = Math.max(0, Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]));
        long y = Math.max(0, Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]));
        return x * y > 0;
    }
}
