package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 04:46
 * @Description:
 */
public class _0501_findMode {


    class Solution {
        int preValue = 0;
        int count = 0;
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            dfs(root);

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            dfs(root.left);
            update(root.val);
            dfs(root.right);
        }

        private void update(int val) {
            if (val == preValue) {
                count++;
            } else {
                preValue = val;
                count = 1;
            }

            if (count == maxCount) {
                list.add(preValue);
            } else if (count > maxCount) {
                list.clear();
                list.add(preValue);
                maxCount = count;
            }
        }
    }
}
