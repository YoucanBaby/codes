package data.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 00:40
 * @Description:
 */
public class _0106_buildTree {

    int[] postorder;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1,
                0, postorder.length - 1);
    }

    public TreeNode buildTree(int inLeft, int inRight,
                              int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        int rootValue = postorder[postRight];
        TreeNode root = new TreeNode(rootValue);
        int pIndex = map.get(rootValue);

        root.left = buildTree(inLeft, pIndex - 1,
                postLeft, postLeft + pIndex - inLeft - 1);
        root.right = buildTree(pIndex + 1, inRight,
                postLeft + pIndex - inLeft, postRight - 1);
        return root;
    }


    class Solution {
        int[] postorder;
        Map<Integer, Integer> map;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(0, inorder.length - 1,
                    0, postorder.length - 1);
        }

        private TreeNode buildTree(int inLeft, int inRight, int postLeft, int postRight) {
            if (inLeft > inRight || postLeft > postRight) {
                return null;
            }

            int rootValue = postorder[postRight];
            int pIndex = map.get(rootValue);
            TreeNode root = new TreeNode(rootValue);

            root.left = buildTree(inLeft, pIndex - 1,
                    postLeft,  postRight - (inRight - pIndex + 1));
            root.right = buildTree(pIndex + 1, inRight,
                    postRight - (inRight - pIndex), postRight - 1);

            return root;
        }
    }
}
