package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 19:18
 * @Description:
 */
public class _0223_computeArea {



    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long X = Math.max(0, Math.min(C, G) - Math.max(A, E));
        long Y = Math.max(0, Math.min(D, H) - Math.max(B, F));
        return (int) ((long) (C - A) * (D - B) + (long) (G - E) * (H - F) - X * Y);
    }
}
