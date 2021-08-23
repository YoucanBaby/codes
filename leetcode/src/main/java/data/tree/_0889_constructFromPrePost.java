package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

        TreeNode root = solution.constructFromPrePost(pre, post);

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                level.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(level);
        }
        System.out.println(res);
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
