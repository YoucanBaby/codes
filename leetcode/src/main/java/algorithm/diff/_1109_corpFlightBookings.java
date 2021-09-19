package algorithm.diff;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.diff
 * @Author: xuyifang
 * @CreateTime: 2021-09-01 00:05
 * @Description:
 */
public class _1109_corpFlightBookings {



    public int[] corpFlightBookings(int[][] bs, int N) {
        int[] diff = new int[N];
        for (int[] b : bs) {
            int start = b[0] - 1;
            int end = b[1] - 1;
            int val = b[2];

            diff[start] += val;
            if (end + 1 < N) {
                diff[end + 1] -= val;
            }
        }

        int[] res = new int[N];
        res[0] = diff[0];
        for (int i = 1; i < N; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
