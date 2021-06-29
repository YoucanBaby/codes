package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 02:25
 * @Description:
 */
public class _0654_constructMaximumBinaryTree {

    public static void main(String[] args) {

    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    // 左右边界能取到
    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = max(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = construct(nums, left, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, right);

        return root;
    }

    public int max(int[] nums, int left, int right) {
        int res = left;

        for (int i = left; i <= right; i++) {
            if (nums[res] < nums[i]) {
                res = i;
            }
        }
        return res;
    }
}
