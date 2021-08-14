package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 10:10
 * @Description:
 */
public class _1150_isMajorityElement {


    public boolean isMajorityElement(int[] nums, int target) {
        int leftIndex = binarySearchLeft(nums, target);
        int rightIndex = binarySearchRight(nums, target);

        return rightIndex - leftIndex > nums.length / 2;
    }

    private int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid =  (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;					// 抛弃右侧解空间
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    private int binarySearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid =  (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;						// 抛弃左侧解空间
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
