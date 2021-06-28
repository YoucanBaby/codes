package data.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 14:39
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(111);
        pq.add(456);
        pq.add(123);

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
