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

    // 贪心+二分查找
    public int lengthOfLIS1(int[] nums) {
        int[] stack = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            int left = 0;
            int right = index;
            while (left < right) {
                int mid = (left + right) / 2;
                if (stack[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            stack[left] = num;
            if (left == index) {
                index++;
            }
        }
        return index;
    }


    // 动态规划
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }


}
