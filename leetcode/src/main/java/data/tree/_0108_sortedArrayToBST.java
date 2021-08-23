package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 21:57
 * @Description:
 */
public class _0108_sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);

        return root;
    }

    // 练习
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(nums, 0, nums.length - 1);
        }

        public TreeNode dfs(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);

            root.left = dfs(nums, left, mid - 1);
            root.right = dfs(nums, mid + 1, right);

            return root;
        }
    }
}
