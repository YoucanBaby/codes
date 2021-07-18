package odd._250;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._250
 * @Author: xuyifang
 * @CreateTime: 2021-07-18 10:38
 * @Description:
 */
public class _5814_addRungs {

    public int addRungs(int[] rungs, int dist) {
        int N = rungs.length;
        int res = 0;

        if (rungs[0] - 0 > dist) {
            int temp = (rungs[0] - 0 - 1) / dist;
            res += temp;
        }

        for (int i = 1; i < N; i++) {
            if (rungs[i] - rungs[i - 1] > dist) {
                int temp = (rungs[i] - rungs[i - 1] - 1) / dist;
                res += temp;
            }
        }

        return res;
    }
}
