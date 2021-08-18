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

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int peakIndex = left;
        int index = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1, false);
    }

    // 山脉数组，要找的目标值，左边界，右边界，是否正向搜索
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean flag) {
        if (flag) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } else {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
