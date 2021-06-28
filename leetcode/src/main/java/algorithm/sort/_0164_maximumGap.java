package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-22 17:08
 * @Description:
 */
public class _0164_maximumGap {

    public static void main(String[] args) {
        int[] nums = {1, 10000000};
        _0164_maximumGap solution = new _0164_maximumGap();

        System.out.println(solution.maximumGap1(nums));
        System.out.println(solution.maximumGap(nums));
    }


    public int maximumGap(int[] nums) {
        int N = nums.length;
        if (N < 2) {
            return 0;
        }

        // 找出nums的最大值
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            max = Math.max(max, num);
        }

        // exp
        int exp = 1;
        // nums有多大，就准备多大的辅助数组
        int[] buffer = new int[N];

        // 最大数有多少位，就循环多少次
        while (exp <= max) {
            int[] count = new int[10];
            // 统计当前位的频率
            for (int i = 0; i < nums.length; i++) {
                int digit = nums[i] / exp % 10;
                count[digit]++;
            }
            // 把这个频率数组变成前缀和数组，统计比当前数字大的数字有多少个
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            // 从右向左，把所有的数字按照当前位数的大小派撇
            for (int i = N - 1; i >= 0; i--) {
                int digit = nums[i] / exp % 10;
                // 注意count[digit]要减1
                buffer[count[digit] - 1] = nums[i];
                count[digit]--;
            }
            System.arraycopy(buffer, 0, nums, 0, N);
            exp *= 10;
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            ret = Math.max(ret, b - a);
        }
        return ret;
    }


    public int maximumGap1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            max = Math.max(max, b - a);
        }

        return max;
    }
}
