package data.tree.nTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree.nTree
 * @Author: xuyifang
 * @CreateTime: 2021-07-15 19:19
 * @Description:
 */
public class _0590_postorder {

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        postorder(root, res);

        return res;
    }

    public void postorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i), res);
        }
        res.add(root.val);
    }
}
