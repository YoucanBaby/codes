package data.hashtable1;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 16:00
 * @Description:
 */
public class _0001_twoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                int[] ret = {i, map.get(nums[i])};
                return ret;
            }
        }

        return new int[0];
    }
}
