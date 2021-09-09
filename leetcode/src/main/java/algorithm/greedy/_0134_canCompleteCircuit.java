package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 11:46
 * @Description:
 */
public class _0134_canCompleteCircuit {

    public static void main(String[] args) {
        _0134_canCompleteCircuit solution = new _0134_canCompleteCircuit();

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        int N = gas.length;
        for (int i = 0; i < N; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare >= 0 ? (minIndex + 1) % N : -1;
    }
}
