package data.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 00:03
 * @Description:
 */
public class _0105_buildTree {

    public static void main(String[] args) {

    }

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen);
    }

    public TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                              int[] inorder, int inLeft, int inRight) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int pIndex = map.get(rootValue);

        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft,
                            inorder, inLeft, pIndex - 1);

        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight,
                            inorder, pIndex + 1, inRight);

        return root;
    }
}
