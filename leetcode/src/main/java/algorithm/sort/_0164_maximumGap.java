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
//        int[] nums = {1, 10000000};
        int[] nums = {1, 3, 100};
        _0164_maximumGap solution = new _0164_maximumGap();

        System.out.println(solution.maximumGap(nums));
        System.out.println(solution.maximumGap1(nums));
        System.out.println(solution.maximumGap2(nums));
    }


    // 暴力
    public int maximumGap2(int[] nums) {
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

    // 基数排序
    public int maximumGap1(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int N = nums.length;
        int max = Integer.MIN_VALUE;        // nums的最大值
        for (int num: nums) {
            max = Math.max(max, num);
        }

        int exp = 1;                    // exp
        int[] buffer = new int[N];      // nums有多大，就准备多大的辅助数组
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
            // 从右向左，把所有的数字按照当前位数的大小排序
            for (int i = N - 1; i >= 0; i--) {
                int digit = nums[i] / exp % 10;
                // 注意count[digit]要减1
                buffer[count[digit] - 1] = nums[i];
                count[digit]--;
            }
            System.arraycopy(buffer, 0, nums, 0, N);
            exp *= 10;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }


    // 桶排序
    public int maximumGap(int[] nums) {
        int N = nums.length;
        if (N < 2) return 0;

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        if (max - min == 0) {
            return 0;
        }

        int d = (int) Math.ceil((double) (max - min) / (N - 1));
        int[][] bucket = new int[N][2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(bucket[i], -1);
        }

        for (int num : nums) {
            int index = (num - min) / d;
            if (bucket[index][0] == -1) {
                bucket[index][0] = bucket[index][1] = num;
            } else {
                bucket[index][0] = Math.min(bucket[index][0], num);
                bucket[index][1] = Math.max(bucket[index][1], num);
            }
        }

        int maxGap = 0;
        int preMax = bucket[0][1];       // 上一个非空桶的最大值
        for (int i = 1; i < N; i++) {
            if (bucket[i][0] == -1) continue;    // 跳过空桶
            maxGap = Math.max(maxGap, bucket[i][0] - preMax);
            preMax = bucket[i][1];
        }
        return maxGap;
    }
}
