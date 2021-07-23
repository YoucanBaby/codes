package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 11:46
 * @Description:
 */
public class _0134_canCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int res = 0;

        int N = gas.length;
        for (int i = 0; i < N; i++) {
            spare += gas[i] - cost[i];

            if (minSpare > spare) {
                minSpare = spare;
                res = i;
            }
        }

        if (spare >= 0) {
            return (res + 1) % N;
        } else {
            return -1;
        }
    }
}
