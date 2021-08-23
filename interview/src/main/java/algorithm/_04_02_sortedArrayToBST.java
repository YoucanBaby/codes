package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 03:14
 * @Description:
 */
public class _04_02_sortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
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
