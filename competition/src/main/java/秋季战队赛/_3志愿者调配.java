package 秋季战队赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: 秋季战队赛
 * @Author: xuyifang
 * @CreateTime: 2021-09-25 15:18
 * @Description:
 */
public class _3志愿者调配 {

    public static void main(String[] args) {
        _3志愿者调配 solution = new _3志愿者调配();

        int[] finalCnt = {4,13,4,3,8};
        long totalNum = 54;
        int[][] relation = {
                {0,3}, {1,3}, {4,3}, {2,3}, {2,5}
        };
        int[][] planes = {
                {1,1}, {3,3}, {2,5}, {1,0}
        };

        int[] res = solution.volunteerDeployment(finalCnt, totalNum, relation, planes);
        System.out.println(Arrays.toString(res));
    }

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] relation, int[][] plans) {
        int M = plans.length;
        int N = finalCnt.length + 1;
        List<Integer>[] edges = new ArrayList[N];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] r : relation) {
            edges[r[0]].add(r[1]);
            edges[r[1]].add(r[0]);
        }

        long[][] dp = new long[N][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int j = 1; j < N; j++) {
            dp[j][0] = finalCnt[j - 1];
            dp[j][1] = 0;
        }

        for (int i = M - 1; i >= 0; i--) {
            int day = plans[i][0];
            int src = plans[i][1];
            if (day == 1) {
                dp[src][0] *= 2;
                dp[src][1] *= 2;
            }
            if (day == 2) {
                for (int dst : edges[src]) {
                    dp[dst][0] -= dp[src][0];
                    dp[dst][1] -= dp[src][1];
                }
            }
            if (day == 3) {
                for (int dst : edges[src]) {
                    dp[dst][0] += dp[src][0];
                    dp[dst][1] += dp[src][1];
                }
            }
        }

        long sumA = 0;
        for (int j = 0; j < N; j++) {
            sumA += dp[j][0];
        }
        long countB = 0;
        for (int j = 0; j < N; j++) {
            countB += dp[j][1];
        }

//        for (int j = 0; j < N; j++) {
//            System.out.println(Arrays.toString(dp[j]));
//        }

        long sum = totalNum - sumA;
        int[] res = new int[N];
        int x = (int) (sum / countB);
        res[0] = (int) (x * countB + dp[0][0]);
        for (int j = 1; j < N; j++) {
            res[j] = (int) (dp[j][0] + x * dp[j][1]);
        }
        return res;
    }

}
