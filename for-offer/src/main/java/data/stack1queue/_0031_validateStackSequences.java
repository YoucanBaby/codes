package data.stack1queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack1queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 06:18
 * @Description:
 */
public class _0031_validateStackSequences {

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        _0031_validateStackSequences solution = new _0031_validateStackSequences();

        System.out.println(solution.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;

        for (int num: pushed) {
            stack.addFirst(num);
            while (!stack.isEmpty() && stack.getFirst() == popped[i]) {
                stack.removeFirst();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
