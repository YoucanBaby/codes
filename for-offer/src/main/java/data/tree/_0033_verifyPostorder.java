package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 16:41
 * @Description:
 */
public class _0033_verifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> stack = new ArrayDeque<>();      // 右边是栈顶，栈顶最小
        int maxValue = Integer.MAX_VALUE;               // 当前节点不能超过的最大值
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > maxValue) {
                return false;
            }
            while (!stack.isEmpty() && stack.getLast() > postorder[i]) {
                maxValue = stack.removeLast();
            }
            stack.addLast(postorder[i]);
        }
        return true;
    }
}
