package algorithm.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 01:57
 * @Description:
 */
public class _1248_numberOfSubarrays {

    public static void main(String[] args) {
        _1248_numberOfSubarrays solution = new _1248_numberOfSubarrays();

        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(solution.numberOfSubarrays(nums, k));
    }


    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);		// 初始值

        int oddCount = 0;
        int res = 0;
        for (int num : nums) {
            oddCount += num & 1;
            res += map.getOrDefault(oddCount - k, 0);
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }
        return res;
    }
}
