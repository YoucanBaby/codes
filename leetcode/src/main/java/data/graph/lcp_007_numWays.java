package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-05 21:40
 * @Description:
 */
public class lcp_007_numWays {

    public static void main(String[] args) {
        int n = 5;
        int[][] relation = {
                {0,2},
                {2,1},
                {3,4},
                {2,3},
                {1,4},
                {2,0},
                {0,4}
        };
        int k = 3;
        lcp_007_numWays solution = new lcp_007_numWays();

        System.out.println(solution.numWays(n, relation, k));
    }


    List<List<Integer>> edges =  new ArrayList<>();
    int res = 0;

    public int numWays2(int n, int[][] relation, int k) {
        // 初始化边
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        // 添加边
        for (int[] edge : relation) {
            int src = edge[0];
            int dst = edge[1];
            edges.get(src).add(dst);
        }
        // dfs
        dfs(0, 0);

        return res;
    }

    public void dfs(int index, int step) {
        // 我不会啊！
    }


    // 动态规划优化
    public int numWays1(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] node : relation) {
                int src = node[0];
                int dst = node[1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n - 1];
    }

    // 动态规划
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;

        for (int i = 0; i < k; i++) {
            for (int[] node : relation) {
                dp[i + 1][node[1]] += dp[i][node[0]];
            }
        }
        return dp[k][n - 1];
    }
}
