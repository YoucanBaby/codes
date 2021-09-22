package algorithm.twopoint;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 10:29
 * @Description:
 */
public class _1477_minSumOfLengths {

    public static void main(String[] args) {
        _1477_minSumOfLengths solution = new _1477_minSumOfLengths();

        int[] nums = {1,1,1,2,2,2,4,4};
        int target = 6;
        System.out.println(solution.minSumOfLengths(nums, target));
    }

    public int minSumOfLengths(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();   // [左边界,右边界]
        int sum = 0;                    // 滑动窗口值的总和
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum > target) {
                sum -= nums[l];
                l++;
            }
            if (sum == target) {
                list.add(new int[] {l, r, r - l + 1});
            }
        }
        Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[2] * 2 >= res) break;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[0] ||
                        list.get(j)[0] < list.get(i)[0] && list.get(j)[1] < list.get(i)[0] ) {
                    res = Math.min(res, list.get(i)[2] + list.get(j)[2]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
