package even._061;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._061
 * @Author: xuyifang
 * @CreateTime: 2021-09-18 22:52
 * @Description:
 */
public class _05861_maxTaxiEarnings {

    public long maxTaxiEarnings(int n, int[][] rides) {
        int N = rides.length;
        for (int i = 0; i < N; i++) {
            rides[i][2] += rides[i][1] - rides[i][0];
        }

        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 0; j++) {
                
            }
        }
        return res;
    }
}
