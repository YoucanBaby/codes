package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 15:41
 * @Description:
 */
public class _1095_findInMountainArray {

    class MountainArray {
        public int get(int index) {
            return index;
        }

        public int length() {
            return 0;
        }
    }



    public int findInMountainArray(int target, MountainArray nums) {
        int left = 0;
        int right = nums.length() - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) < nums.get(mid + 1)) {
                left = mid + 1;
            } else if (nums.get(mid) > nums.get(mid + 1)) {
                right = mid;
            }
        }
        int peak = left;

        // 先搜索左边数组，再搜索右边数组
        int index = binarySearch1(nums, target, 0, peak);
        if (index != -1) return index;
        return binarySearch2(nums, target, peak + 1, nums.length() - 1);
    }

    private int binarySearch1(MountainArray nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearch2(MountainArray nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println("???");
        }
        return -1;
    }

}
