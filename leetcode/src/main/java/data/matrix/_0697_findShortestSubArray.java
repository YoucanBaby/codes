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
        // 使用哈希表存储 值 = [出现次数, 首次出现的位置, 最后出现的位置]
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                int[] arr = {1, i, i};
                map.put(nums[i], arr);
            }
        }

        // 遍历该哈希表，找到元素出现次数最多，且前后位置差最小的数。

        int maxNum = 0;
        int minLen = 0;

        for (Map.Entry<Integer, int[]> entry: map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum == arr[0]) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            } else if(maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            }
        }
        return minLen;
    }
}
