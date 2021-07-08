package algorithm.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 02:13
 * @Description:
 */
public class _0974_subarraysDivByK {

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1,0};
        int k = 5;
        _0974_subarraysDivByK solution = new _0974_subarraysDivByK();

        System.out.println(solution.subarraysDivByK(nums,k));
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0;
        int res = 0;

        for (int num : nums) {
            preSum += num;
            preSum %= k;
            int key = (preSum + k) % k;

            res += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return res;
    }
}
