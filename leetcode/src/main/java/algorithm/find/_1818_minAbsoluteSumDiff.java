package algorithm.find;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 03:51
 * @Description:
 */
public class _1818_minAbsoluteSumDiff {

    public static void main(String[] args) {
        int[] nums1 = {1,7,5};
        int[] nums2 = {2,3,5};
        _1818_minAbsoluteSumDiff solution = new _1818_minAbsoluteSumDiff();

        System.out.println(solution.minAbsoluteSumDiff(nums1, nums2));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = (int) (Math.pow(10, 9) + 7);
        int N = nums1.length;

        int[] nums = new int[N];
        System.arraycopy(nums1,0, nums, 0, N);
        Arrays.sort(nums);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(nums, nums2[i]);
            max = Math.max(max, diff - Math.abs(nums[j] - nums2[i]));
            if (j + 1 < N) {
                max = Math.max(max, diff - Math.abs(nums[j + 1] - nums2[i]));
            }
            if (j - 1 >= 0) {
                max = Math.max(max, diff - Math.abs(nums[j - 1] - nums2[i]));
            }
        }
        return (sum - max + MOD) % MOD;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
