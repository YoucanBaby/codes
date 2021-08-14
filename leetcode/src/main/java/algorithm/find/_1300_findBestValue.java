package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 07:34
 * @Description:
 */
public class _1300_findBestValue {


    public int findBestValue(int[] nums, int target) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int left = 0;
        int right = max;

        while (left < right) {
            int mid = (left + right) / 2;
            if (getSum(nums, mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int sum1 = getSum(nums, left - 1);
        int sum2 = getSum(nums, left);
        return target - sum1 <= sum2 - target ? left - 1 : left;
    }

    private int getSum(int[] nums, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }
}
