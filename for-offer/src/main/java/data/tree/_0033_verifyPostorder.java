package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 16:41
 * @Description:
 */
public class _0033_verifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        int index = left;
        while (postorder[index] < postorder[right]) {
            index++;
        }
        int mid = index;
        while (postorder[index] > postorder[right]) {
            index++;
        }

        return index == right && recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
    }
}
