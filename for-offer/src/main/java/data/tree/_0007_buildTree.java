package data.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 14:56
 * @Description:
 */
public class _0007_buildTree {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;

       map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight,
                    int[] inorder, int inLeft, int inRight) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int pIndex = map.get(preorder[preLeft]);
        TreeNode root = new TreeNode(inorder[pIndex]);

        root.left = build(preorder, preLeft + 1, preLeft + pIndex - inLeft,
                        inorder, inLeft, pIndex - 1);

        root.right = build(preorder, preLeft + pIndex - inLeft + 1, preRight,
                        inorder, pIndex + 1, inRight);

        return root;
    }
}
