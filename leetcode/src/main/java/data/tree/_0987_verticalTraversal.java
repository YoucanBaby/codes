package data.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 02:35
 * @Description:
 */
public class _0987_verticalTraversal {


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
