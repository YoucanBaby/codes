package data.tree;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 02:35
 * @Description:
 */
public class _0987_verticalTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
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


    class Solution {

        List<Location> locations = new ArrayList();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            dfs(root, 0, 0);
            Collections.sort(locations);

            List<List<Integer>> res = new ArrayList();
            res.add(new ArrayList<>());
            int pre = locations.get(0).x;

            for (Location loc: locations) {
                if (loc.x != pre) {
                    pre = loc.x;
                    res.add(new ArrayList<>());
                }
                res.get(res.size() - 1).add(loc.val);
            }
            return res;
        }

        public void dfs(TreeNode node, int x, int y) {
            if (node != null) {
                locations.add(new Location(x, y, node.val));
                dfs(node.left, x - 1, y + 1);
                dfs(node.right, x + 1, y + 1);
            }
        }
    }

    class Location implements Comparable<Location>{
        int x, y, val;
        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);
            else
                return Integer.compare(this.val, that.val);
        }
    }
}
