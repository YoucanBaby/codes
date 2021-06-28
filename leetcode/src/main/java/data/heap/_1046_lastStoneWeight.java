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

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones) {
            pq.add(stone);
        }
        System.out.println(pq);

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(Math.abs(a - b));
            System.out.println(pq);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
