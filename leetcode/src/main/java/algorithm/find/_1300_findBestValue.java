package algorithm.find;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 07:34
 * @Description:
 */
public class _1300_findBestValue {


    public static void main(String[] args) {
        _1300_findBestValue solution = new _1300_findBestValue();

        int[] nums = {2,3,5};
        int target = 10;
        System.out.println(solution.findBestValue(nums, target));
    }

    public int findBestValue(int[] nums, int target) {
        int left = 0;
        int right = Arrays.stream(nums).max().getAsInt();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getSum(nums, mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int diff1 = Math.abs(target - getSum(nums, right));
        int diff2 = Math.abs(target - getSum(nums, left));
        return diff1 <= diff2 ? right : left;
    }

    private int getSum(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.min(num, mid);
        }
        return sum;
    }
}
