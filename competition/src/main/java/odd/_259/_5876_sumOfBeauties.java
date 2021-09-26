package odd._259;

import java.util.TreeMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._259
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 10:34
 * @Description:
 */
public class _5876_sumOfBeauties {


    public int sumOfBeauties(int[] nums) {
        int N = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 2; i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int res = 0;
        int max = nums[0];
        for (int i = 1; i <= N - 2; i++) {
            if (nums[i] > max && nums[i] < map.firstKey()) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }

            max = Math.max(max, nums[i]);
            if (map.get(nums[i + 1]) == 1) {
                map.remove(nums[i + 1]);
            } else {
                map.put(nums[i + 1], map.get(nums[i + 1]) - 1);
            }
        }
        return res;
    }
}
