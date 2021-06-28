package algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: interview
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 03:45
 * @Description:
 */
public class _17_14_smallestK {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        _17_14_smallestK solution = new _17_14_smallestK();

        System.out.println(Arrays.toString(solution.smallestK1(arr, k)));
        System.out.println(Arrays.toString(solution.smallestK(arr, k)));
    }

    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];

        // 大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 添加前k个元素
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // 比较后面的元素
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll();
        }
        return ret;
    }

    public int[] smallestK1(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }
}
