package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 17:44
 * @Description:
 */
public class _0033_search {

    // 如果左边/右边有序，target落入左边，找左边；target落入右边，找右边
    public int search1(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[N - 1]){
                if (nums[mid] < target && target <= nums[N - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }

        int l = 0, r = 0;
        if (target >= nums[left] && target <= nums[N - 1]) {
            l = left;
            r = N - 1;
        } else {
            l = 0;
            r = left - 1;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
