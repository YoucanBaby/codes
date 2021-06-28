package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 21:14
 * @Description:
 */
public class Node {

    int data;
    Node left;
    Node right;

    boolean leftTag = false;        // true代表有左节点，false代表无
    boolean rightTag = false;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
