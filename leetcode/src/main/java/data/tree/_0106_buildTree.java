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

    public static void main(String[] args) {

    }

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;

        map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inLen - 1,
                    postorder, 0, postLen - 1);
    }

    // 左右边界都能取到
    public TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                              int[] postorder, int postLeft, int postRight) {

        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        int rootValue = postorder[postRight];
        int pIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(inorder, inLeft, pIndex - 1,
                            postorder, postLeft, postRight - inRight + pIndex - 1);

        root.right = buildTree(inorder, pIndex + 1, inRight,
                            postorder, postRight - inRight + pIndex, postRight - 1);

        return root;
    }
}
