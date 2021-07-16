package data.tree.nTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-15 11:11
 * @Description:
 */
public class _0589_preorder {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        preorder(root, res);

        return res;
    }

    public void preorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i), res);
        }
    }
}
