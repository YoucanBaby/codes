package data.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 22:33
 * @Description:
 */
public class _0739_dailyTemperatures {

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        _0739_dailyTemperatures solution = new _0739_dailyTemperatures();

        int[] res1 = solution.dailyTemperatures(T);
        System.out.println(Arrays.toString(res1));

        int[] res2 = solution.dailyTemperatures2(T);
        System.out.println(Arrays.toString(res2));
    }

    public int[] dailyTemperatures2(int[] T) {
        // 栈用于保存数组下标
        Deque<Integer> stack = new LinkedList<>();
        int N = T.length;
        int[] ret = new int[N];

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && T[stack.getFirst()] < T[i]) {
                int j = stack.removeFirst();
                ret[j] = i - j;
            }
            stack.addFirst(i);
        }
        return ret;
    }

    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] ret = new int[N];

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (T[j] > T[i]) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        return ret;
    }
}
