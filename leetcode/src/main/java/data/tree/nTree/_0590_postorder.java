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

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return res;
        for (Node children : root.children) {
            postorder(children);
        }
        res.add(root.val);
        return res;
    }
}
