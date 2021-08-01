package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-05 14:50
 * @Description:
 */
public class _0300_lengthOfLIS {

    // 动态规划(贪心+二分查找)
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;

        for (int num: nums) {
            // 二分查找合适的位置
            int left = 0;
            int right = res;
            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[right] = num;
            if (res == right) {
                res++;
            }
        }
        return res;
    }


    // 动态规划
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 遍历dp表，找到最大值
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
