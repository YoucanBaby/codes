package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-07-16 04:59
 * @Description:
 */
public class _0053_search {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        _0053_search solution = new _0053_search();

        solution.search(nums, target);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target) - binarySearch(nums, target - 1);
    }

    public int binarySearch(int[] nums, int target) {
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
