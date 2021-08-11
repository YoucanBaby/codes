import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 03:37
 * @Description:
 */
public class _018_breakfastNumber {

    public static void main(String[] args) {
        _018_breakfastNumber solution = new _018_breakfastNumber();
        int[] nums1 = {2,1,1};
        int[] nums2 = {8,9,5,1};
        int target = 9;

        System.out.println(solution.breakfastNumber(nums1, nums2, target));
    }

    public int breakfastNumber(int[] nums1, int[] nums2, int target) {
        int MOD = (int) (1e9 + 7);
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            long index = binarySearch(nums2, target - nums1[i]);
            if (index == 0) {
                break;
            }
            res += index;
            res %= MOD;
        }
        return (int) res;
    }

    private long binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
