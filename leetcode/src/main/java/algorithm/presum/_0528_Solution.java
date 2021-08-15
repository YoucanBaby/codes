package algorithm.presum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 18:02
 * @Description:
 */
public class _0528_Solution {

    class Solution {
        List<Integer> preSum = new ArrayList<>();

        public Solution(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
                preSum.add(sum);
            }
        }

        public int pickIndex() {
            Random random = new Random();
            int randomNum = random.nextInt(preSum.get(preSum.size() - 1)) + 1;
            int left = 0;
            int right = preSum.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (preSum.get(mid) == randomNum) {
                    return mid;
                } else if (preSum.get(mid) < randomNum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
