import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:30
 * @Description:
 */

public class test {
    public static void main(String[] args) {
        test test = new test();


    }

    public int[] addVal(int[] nums, int left, int right, int val) {
        int N = nums.length;
        int[] diff = new int[N];
        for (int i = 1; i < N; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        diff[left] += val;
        diff[right + 1] -= val;

        for (int i = 1; i < N; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }
        return nums;
    }


    public TreeNode getLastNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth > rightDepth) {
            return getLastNode(root.left);
        } else {
            return getLastNode(root.right);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
