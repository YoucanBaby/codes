package algorithm.sort;

import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 21:33
 * @Description:
 */
public class _0703_KthLargest {


    class KthLargest {

        PriorityQueue<Integer> pq;
        int size;

        public KthLargest(int k, int[] nums) {
            size = k;
            pq = new PriorityQueue<>(size);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (pq.size() < size) {
                pq.add(val);
            } else if (val > pq.peek()){
                pq.remove();
                pq.add(val);
            }
            return pq.peek();
        }
    }

}
