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

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(nums, mid) == m) {
                right = mid - 1;
            } else if (getCount(nums, mid) < m) {      // 向左分数组增加，向右分组数减少
                right = mid - 1;
            } else if (getCount(nums, mid) > m){
                left = mid + 1;
            }
        }
        return left;
    }

    public int getCount(int[] nums, int mid) {
        int count = 1;      // 默认分一组
        int sum = 0;        // 每组的总和
        for (int num : nums) {
            sum += num;
            if (sum > mid) {       // 重新累加新的一组
                sum = num;
                count++;
            }
        }
        return count;      // 如果分组数超过m，那这个数是不可行的
    }
}
