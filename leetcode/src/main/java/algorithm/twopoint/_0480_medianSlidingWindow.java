package algorithm.twopoint;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-17 22:38
 * @Description:
 */
public class _0480_medianSlidingWindow {

    private double get(PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ, int k) {
        if ((k & 1) == 1) {
            return maxPQ.peek();
        } else {
            return (double) (maxPQ.peek() + minPQ.peek()) / 2;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int K) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();            // <欠账, 欠账的个数>
        int N = nums.length;
        double[] res = new double[N - K + 1];

        for (int i = 0; i < K; i++) {
            maxPQ.add(nums[i]);
        }
        for (int i = 0; i < K / 2; i++) {
            minPQ.add(maxPQ.remove());
        }
        res[0] = get(maxPQ, minPQ, K);

        for (int right = K; right < N; right++) {
            int balance = 0;            // 本次窗口滑动导致small堆元素数目与big堆元素个数差值的增量

            // 删除窗口左边界的元素，堆无法直接删除掉某个指定元素，先欠下这个账，等某次元素出现在堆顶的时候，再删除他
            // map记录这个元素欠账的个数
            int left = right - K;
            if (!maxPQ.isEmpty() && nums[left] <= maxPQ.peek()) {
                balance--;
            } else {
                balance++;
            }
            map.put(nums[left], map.getOrDefault(nums[left], 0) + 1);   // 心里删除左边界的元素，记下需要删除的值

            // 添加窗口右边界的元素
            if (!maxPQ.isEmpty() && nums[right] <= maxPQ.peek()) {
                maxPQ.add(nums[right]);
                balance++;
            } else {
                minPQ.add(nums[right]);
                balance--;
            }

            // 经过上面的操作，balance要么为0，要么为2，要么为-2
            // 如果balance为0，在这次窗口滑动之前已经是平衡的，这次调整也没有让两堆的数目变化，所以不用调整两边的堆。
            // 如果balance为2，就说明大根堆的元素比小根堆的元素多了两个
            // 如果balance为-2，就说明大根堆的元素比小根堆的元素少了两个
            if (balance > 0) {
                minPQ.add(maxPQ.remove());
            }
            if (balance < 0) {
                maxPQ.add(minPQ.remove());
            }

            // 调整完了，现在该欠债还钱了。不能让那些早该删除的元素涉及到中位数的运算。
            // 分别检查两边的堆顶元素，如果堆顶元素欠着债，则弹出堆顶元素，直到堆顶元素没有欠债为止。
            while (!maxPQ.isEmpty() && map.getOrDefault(maxPQ.peek(), 0) > 0) {
                map.put(maxPQ.peek(), map.getOrDefault(maxPQ.peek(), 0) - 1);
                maxPQ.remove();
            }
            while (!minPQ.isEmpty() && map.getOrDefault(minPQ.peek(), 0) > 0) {
                map.put(minPQ.peek(), map.getOrDefault(minPQ.peek(), 0) - 1);
                minPQ.remove();
            }

            // 最后，添加中位数
            res[left + 1] = get(maxPQ, minPQ, K);
        }
        return res;
    }
}
