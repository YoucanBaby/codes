package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 10:29
 * @Description:
 */
public class _1477_minSumOfLengths {


    public int minSumOfLengths(int[] nums, int target) {
        int minLength = Integer.MAX_VALUE;      // 最短长度
        int minLength2 = Integer.MAX_VALUE;     // 第二短长度

        int sum = 0;        // 滑动窗口值的总和
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                if (right - left + 1 <= minLength) {
                    minLength2 = minLength;
                    minLength = right - left + 1;
                } else {
                   if (right - left + 1 <= minLength2) {
                       minLength2 = right - left + 1;
                   }
                }
            }
        }
        if (minLength == Integer.MAX_VALUE || minLength2 == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLength + minLength2;
        }
    }
}
