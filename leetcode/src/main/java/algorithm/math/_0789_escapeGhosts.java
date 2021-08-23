package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-08-22 23:14
 * @Description:
 */
public class _0789_escapeGhosts {


    public boolean escapeGhosts(int[][] ghosts, int[] t) {
        int cur = getDistance(0, 0, t[0], t[1]);
        for (int[] g : ghosts) {
            if (getDistance(g[0], g[1], t[0], t[1]) <= cur) {
                return false;
            }
        }
        return true;
    }

    private int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
