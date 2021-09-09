package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-09-09 03:13
 * @Description:
 */
public class _0502_findMaximizedCapital {

    public static void main(String[] args) {
        _0502_findMaximizedCapital solution = new _0502_findMaximizedCapital();
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};

        System.out.println(solution.findMaximizedCapital(k, w, profits, capital));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int N = profits.length;
        int[][] capitalAndProfits = new int[N][2];
        for (int i = 0; i < N; i++) {
            capitalAndProfits[i][0] = capital[i];
            capitalAndProfits[i][1] = profits[i];
        }
        Arrays.sort(capitalAndProfits, (o1, o2) -> o1[0] - o2[0]);

        int index = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        while (k-- > 0) {
            while (index < N && capitalAndProfits[index][0] <= w) {
                pq.add(capitalAndProfits[index++]);
            }
            if (pq.isEmpty()) break;
            w += pq.remove()[1];
        }
        return w;
    }
}
