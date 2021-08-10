package data.heap;

import java.util.PriorityQueue;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.heap
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 08:57
 * @Description:
 */
public class _1046_lastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        _1046_lastStoneWeight solution = new _1046_lastStoneWeight();

        System.out.println(solution.lastStoneWeight(stones));
    }


    public int lastStoneWeight(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        while (pq.size() >= 2) {
            int a = pq.remove();
            int b = pq.remove();
            pq.add(Math.abs(a - b));
        }
        return pq.remove();
    }
}
