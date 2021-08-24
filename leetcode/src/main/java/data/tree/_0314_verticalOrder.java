package data.tree;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 21:12
 * @Description:
 */
public class _0314_verticalOrder {


    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> res = new TreeMap<>();      // <层级，在当前层级上的节点>
        Map<TreeNode, Integer> map = new HashMap<>();           // <节点，节点的层级>
        map.put(root, 0);

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            int level = map.get(node);
            res.computeIfAbsent(level, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                deque.addLast(node.left);
                map.put(node.left, level - 1);
            }
            if (node.right != null) {
                deque.addLast(node.right);
                map.put(node.right, level + 1);
            }
        }
        return new ArrayList<>(res.values());
    }
}
