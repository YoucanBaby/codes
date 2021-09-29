package data.heap;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.heap
 * @Author: xuyifang
 * @CreateTime: 2021-08-10 01:35
 * @Description:
 */
public class _0295_MedianFinder {

    class MedianFinder {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int size = 0;

        public MedianFinder() {}

        public void addNum(int num) {
            size += 1;
            maxPQ.add(num);
            minPQ.add(maxPQ.remove());
            if ((size & 1) == 1) {
                maxPQ.add(minPQ.remove());
            }
        }

        public double findMedian() {
            if ((size & 1) == 1) {
                return (double) maxPQ.peek();
            } else {
                return ((double) (maxPQ.peek() + minPQ.peek())) / 2;
            }
        }
    }
}
