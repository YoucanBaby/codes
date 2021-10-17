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



    int[] preorder;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, preorder.length - 1,
                0, inorder.length - 1);
    }

    // 前序遍历数组的左/右边界，中序遍历数组的左/右边界
    public TreeNode buildTree(int preLeft, int preRight,
                              int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int pIndex = map.get(rootValue);

        root.left = buildTree(preLeft + 1, preLeft + pIndex - inLeft,
                inLeft, pIndex - 1);
        root.right = buildTree(preLeft + pIndex - inLeft + 1, preRight,
                pIndex + 1, inRight);

        return root;
    }


    // 用哈希映射记录中序遍历数组的值和下标，前序遍历构造数组
    // 在前序遍历数组获得根节点，然后获得中序遍历数组中的下标，新建节点。递归左右节点。
    // 返回的是当前节点

    // 练习
    class Solution {
        int[] preorder;
        Map<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(0, preorder.length - 1,
                            0, inorder.length - 1);
        }

        // 前序遍历数组的左/右边界，中序遍历数组的左/右边界
        public TreeNode buildTree(int preLeft, int preRight,
                                  int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }

            int rootValue = preorder[preLeft];
            int pIndex = map.get(rootValue);
            TreeNode root = new TreeNode(rootValue);

            root.left = buildTree(preLeft + 1, preLeft + pIndex - inLeft,
                                    inLeft, pIndex - 1);
            root.right = buildTree(preLeft + pIndex - inLeft + 1, preRight,
                                    pIndex + 1, inRight);

            return root;
        }
    }
}
