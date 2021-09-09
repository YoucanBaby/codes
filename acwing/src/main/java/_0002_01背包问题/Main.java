package _0002_01背包问题;

import java.util.Scanner;


class Main {

    public static void main(String args[]) throws Exception {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();

        }
        scanner.close();

        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= w[i]; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[N][N]);
    }

    public int zeroOneBag(int[] v, int[] w, int V, int N) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }

    public int zeroOneBag1(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target];
    }
}
