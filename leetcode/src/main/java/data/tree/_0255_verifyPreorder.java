package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 15:53
 * @Description:
 */
public class _0255_verifyPreorder {

    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();          // 栈顶在右边，栈顶最大
        int minValue = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < minValue) {
                return false;
            }
            while (!stack.isEmpty() && preorder[i] > stack.getLast()) {
                minValue = stack.removeLast();
            }
            stack.addLast(preorder[i]);
        }
        return true;
    }
}
