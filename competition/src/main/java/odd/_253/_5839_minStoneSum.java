package odd._253;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._253
 * @Author: xuyifang
 * @CreateTime: 2021-08-08 10:33
 * @Description:
 */
public class _5839_minStoneSum {

    public int minStoneSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            max = max - max / 2;
            pq.add(max);
        }

        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}
