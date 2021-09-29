package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 18:06
 * @Description:
 */
public class _0081_search {

    public static void main(String[] args) {
        _0081_search solution = new _0081_search();
        int[] nums = {2,2,2,3,2,2,2};
        int target = 3;

        System.out.println(solution.search(nums, target));
    }

    public boolean search1(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]){
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while (left < N - 1 && nums[left] == nums[N - 1]) left++;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
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
                return true;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
