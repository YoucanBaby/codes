package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 22:33
 * @Description:
 */
public class _0410_splitArray {


    public int splitArray(int[] nums, int m) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max;
        int right = sum;

        while (left < right) {
            int mid = (left + right) / 2;
            // 如果当前元素可行，那目标就在左边
            if (check(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int[] nums, int m, int target) {
        int count = 1;      // 默认分一组
        int sum = 0;        // 每组的总和
        for (int num : nums) {
            if (sum + num <= target) {
                sum += num;     // 重新累加新的一组
            } else {
                sum = num;
                count++;
            }
        }
        // 如果分组数超过m，那这个数是不可行的
        if (count > m) {
            return false;
        } else {
            return true;
        }
    }
}
