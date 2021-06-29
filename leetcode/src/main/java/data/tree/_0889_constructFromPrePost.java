package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 05:09
 * @Description:
 */
public class _0889_constructFromPrePost {

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        _0889_constructFromPrePost solution = new _0889_constructFromPrePost();

        System.out.println(solution.constructFromPrePost(pre, post));
    }

    int preIndex = 0;
    int postIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;

        if (root.val != post[postIndex]) {
            root.left = constructFromPrePost(pre, post);
        }
        if (root.val != post[postIndex]) {
            root.right = constructFromPrePost(pre, post);
        }
        postIndex++;

        return root;
    }
}
