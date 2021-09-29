package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 17:16
 * @Description:
 */
public class _0034_searchRange {


    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1,-1};
        }

        int leftIndex = binarySearchLeft(nums, target);
        int rightIndex = binarySearchRight(nums, target);
        if (leftIndex > rightIndex) {
            return new int[] {-1,-1};
        } else {
            return new int[] {leftIndex, rightIndex};
        }
    }

    private int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int binarySearchRight(int[] nums, int target) {
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
        return left - 1;
    }
}
