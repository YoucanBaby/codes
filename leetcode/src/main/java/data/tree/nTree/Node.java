package data.tree.nTree;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree.nTree
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 22:11
 * @Description:
 */
class Node {

    public int val;
    public List<Node> children;

    public Node() {

    }

    public Node(int _val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};
