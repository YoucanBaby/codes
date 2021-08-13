package algorithm.find;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 09:35
 * @Description:
 */
public class _0475_findRadius {

    // 遍历house，得到坐标小于heater的个数，再得到house离heater最近的距离，更新这个距离。
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        for (int house : houses) {
            int index = binarySearch(heaters, house);
            int leftDist = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(leftDist, rightDist));
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
