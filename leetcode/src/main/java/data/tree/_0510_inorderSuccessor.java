package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 22:16
 * @Description:
 */
public class _0510_inorderSuccessor {


    public Node inorderSuccessor(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return getMostLeft(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public Node getMostLeft(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    // 练习
    class Solution {
        public Node inorderSuccessor(Node node) {
            if (node == null) {
                return null;
            }

            if (node.right != null) {
                return getMostLeft(node.right);
            } else {
                Node parent = node.parent;
                while (parent != null && parent.right == node) {
                    node = parent;
                    parent = node.parent;
                }
                return parent;
            }
        }

        private Node getMostLeft(Node node) {
            if (node == null) {
                return null;
            }
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }
}
