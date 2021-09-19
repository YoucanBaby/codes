package fall;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @BelongsProject: codes
 * @BelongsPackage: fall
 * @Author: xuyifang
 * @CreateTime: 2021-09-11 16:12
 * @Description:
 */
public class _2_maxmiumScore {

    public static void main(String[] args) {
        _2_maxmiumScore solution = new _2_maxmiumScore();

        for (int i = 0; i < 100000; i++) {
            int[] cards = solution.getRandom(5, 1, 9);
            int res = solution.maxmiumScore(cards, 3);
            if ((res & 1) == 1) {
                System.out.println(Arrays.toString(cards) + "  " + res);
            }
            if (res == 0) {
                System.out.println(Arrays.toString(cards) + "  " + res);
            }
        }

        int[] cards = {1,1,2,2,3};
        System.out.println(solution.maxmiumScore(cards, 3));
    }

    public int maxmiumScore(int[] cards, int cnt) {
        final int MIN = (int) -1e5;
        PriorityQueue<Integer> oddPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> evenPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int card : cards) {
            if ((card & 1) == 1) {
                oddPQ.add(card);
            } else {
                evenPQ.add(card);
            }
        }

        int res = 0;
        while (cnt > 0) {
            if (evenPQ.size() + oddPQ.size() < cnt) {
                return 0;
            }
            if ((cnt & 1) == 1 && evenPQ.size() == 0) {
                return 0;
            }

            int even = evenPQ.isEmpty() ? MIN : evenPQ.poll();
            int odd1 = oddPQ.isEmpty() ? MIN : oddPQ.poll();
            int odd2 = oddPQ.isEmpty() ? MIN : oddPQ.poll();

            if (cnt == 1) {
                res += even;
                cnt -= 1;
                if (odd1 != MIN) oddPQ.add(odd1);
                if (odd2 != MIN) oddPQ.add(odd2);
            }
            else if (cnt == 2 && evenPQ.size() == 0) {
                cnt -= 2;
            }
            else {
                if (odd1 + odd2 >= even) {
                    res += odd1 + odd2;
                    cnt -= 2;
                    if (even != MIN) evenPQ.add(even);
                } else {
                    res += even;
                    cnt -= 1;
                    oddPQ.add(odd1);
                    oddPQ.add(odd2);
                }
            }
        }
        return res;
    }

    public int[] getRandom(int n, int min, int max) {
        int[] res = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            res[i] = min + random.nextInt(max);
        }
        return res;
    }
}
