package even._057;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._057
 * @Author: xuyifang
 * @CreateTime: 2021-07-25 00:02
 * @Description:
 */
public class _5196_canSeePersonsCount {

    public static void main(String[] args) {
        int[] heights = {10,6,8,5,11,9};
        _5196_canSeePersonsCount solution = new _5196_canSeePersonsCount();

        int[] res = solution.canSeePersonsCount(heights);
        System.out.println(Arrays.toString(res));
    }

    // 单调栈
    public int[] canSeePersonsCount(int[] heights) {
        int N = heights.length;
        int[] res = new int[N];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(N - 1);

        for (int i = N - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(i);
        }

        return res;
    }
}
