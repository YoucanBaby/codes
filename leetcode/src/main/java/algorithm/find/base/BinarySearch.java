package algorithm.find.base;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 17:40
 * @Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[] nums = {1,2,8,17,56,101,156,254};
        int target = 156;

        System.out.println(solution.binarySearch(nums, target));
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid =  (left + right) / 2;      // mid向下取整，是左边数组的最后一位
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    public int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid =  (left + right) / 2;
            if (nums[mid] == target ) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 左边界
    public int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid =  (left + right) / 2;
            if (nums[mid] == target) {
                // 锁定左边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 最后检查left越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // 右边界
    public int binarySearch3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid =  (left + right) / 2;
            if (nums[mid] == target) {
                // 锁定右边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 最后检查right越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
