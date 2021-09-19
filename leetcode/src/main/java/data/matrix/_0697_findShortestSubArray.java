package data.matrix;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 03:02
 * @Description:
 */
public class _0697_findShortestSubArray {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        _0697_findShortestSubArray solution = new _0697_findShortestSubArray();

        System.out.println(solution.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[] {1, i, i});
            } else {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }
        }

        int maxCount = 0;
        int minLen = Integer.MAX_VALUE;
        for (int[] val : map.values()) {
            if (maxCount < val[0]) {
                maxCount = val[0];
                minLen = val[2] - val[1] + 1;
            } else if (maxCount == val[0]) {
                minLen = Math.min(minLen, val[2] - val[1] + 1);
            }
        }
        return minLen;
    }
}
