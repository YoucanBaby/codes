package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 15:25
 * @Description:
 */
public class _1283_smallestDivisor {


    public int smallestDivisor(int[] nums, int threshold) {
        int left = 0;
        int right = (int) 1e6;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(nums, threshold, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean possible(int[] nums, int threshold, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / mid);
        }
        return sum <= threshold;
    }
}
