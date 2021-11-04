package data.tree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-29 01:50
 * @Description:
 */
public class _0863_distanceK {

    List<Integer> res = new ArrayList<>();
    TreeNode father;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root, target, null);        // 把树分成两棵，一棵以目标节点为根，一棵以目标节点爸爸为根。
        search(target, 0, K);           // 搜索第一棵树深度为K的节点
        search(father, 0, K - 1);    // 搜索第二棵树深度为K-1的节点
        return res;
    }

    // 前序遍历，找目标节点，并把它的父亲节点变成根节点
    public boolean dfs(TreeNode root, TreeNode target, TreeNode father) {
        if (root == null) {
            return false;
        }

        if (root == target) {
            this.father = father;                   // 如果当前节点是目标节点
            return true;
        }

        if (dfs(root.left, target, root)) {         // 如果当前节点的左儿子是目标节点，那它的左节点改成它的父亲
            root.left = father;
            return true;
        }
        if (dfs(root.right, target, root)) {        // 如果当前节点的右儿子是目标节点，那它的右节点改成它的父亲
            root.right = father;
            return true;
        }
        return false;
    }

    // 前序遍历，找深度为k的节点的值
    public void search(TreeNode root, int depth, int K) {
        if (root == null) {
            return;
        }
        if (depth == K) {
            res.add(root.val);
        }
        search(root.left, depth + 1, K);
        search(root.right, depth + 1, K);
    }


    class Solution {

        List<Integer> res = new ArrayList<>();
        TreeNode father = null;         // 目标节点的父节点

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            splitTree(root, target, null);
            search(target, 0, K);
            search(father, 0, K - 1);
            return res;
        }

        // 如果当前节点是目标节点说明找到了，那么父亲节点要更新。
        // 如果当前节点的左儿子是目标节点，则当前节点的左儿子变成它的父亲。
        // 如果当前节点的右儿子是目标节点，则当前节点的右儿子变成它的父亲。
        public boolean splitTree(TreeNode root, TreeNode target, TreeNode father) {
            if (root == null) {
                return false;
            }

            if (root == target) {
                this.father = father;
                return true;
            }

            if (splitTree(root.left, target, root)) {
                root.left = father;
                return true;
            }
            if (splitTree(root.right, target, root)) {
                root.right = father;
                return true;
            }
            return false;
        }

        // 向下找所有深度为K的节点
        public void search (TreeNode root, int depth, int K) {
            if (root == null) {
                return;
            }
            if (depth == K) {
                res.add(root.val);
            }
            search(root.left, depth + 1, K);
            search(root.right, depth + 1, K);
        }
    }
}
