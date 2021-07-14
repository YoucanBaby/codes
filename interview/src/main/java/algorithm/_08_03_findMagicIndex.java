package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 09:50
 * @Description:
 */
public class _08_03_findMagicIndex {

    public int findMagicIndex(int[] nums) {
        int N = nums.length;
        int idx = 0;
        while (idx < N) {
            if (nums[idx] == idx) {
                return idx;
            } else if (nums[idx] > idx) {
                idx = nums[idx];
            } else {
                idx++;
            }
        }
        return -1;
    }

    public int findMagicIndex1(int[] nums) {
        return magicIndex(nums, 0, nums.length - 1);
    }

    // 二分搜索递归，不会
    public int magicIndex(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == mid) {
            return mid;
        }
        return 0;
    }
}
