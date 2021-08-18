package data.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.heap
 * @Author: xuyifang
 * @CreateTime: 2021-08-11 09:58
 * @Description:
 */
public class _0041_MedianFinder {

    class MedianFinder {
        PriorityQueue<Integer> maxPQ;
        PriorityQueue<Integer> minPQ;
        int size;

        public MedianFinder() {
            maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minPQ = new PriorityQueue<>();
            size = 0;
        }

        public void addNum(int num) {
            size += 1;
            maxPQ.add(num);
            minPQ.add(maxPQ.remove());
            if ((size & 1) == 1) {
                maxPQ.add(minPQ.remove());
            }
        }

        public double findMedian() {
            if ((size & 1) == 0) {
                return (double) (maxPQ.peek() + minPQ.peek()) / 2;
            } else {
                return maxPQ.peek();
            }
        }
    }
}
