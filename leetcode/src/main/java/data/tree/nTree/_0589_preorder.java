package data.tree.nTree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-15 11:11
 * @Description:
 */
public class _0589_preorder {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return res;

        res.add(root.val);
        for (Node children : root.children) {
            preorder(children);
        }
        return res;
    }

}
