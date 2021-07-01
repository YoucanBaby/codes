package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 18:54
 * @Description:
 */
public class _0036_treeToDoublyList {

    Node pre;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }

        dfs(cur.left);

        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }


}
