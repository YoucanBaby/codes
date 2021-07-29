package data.tree;

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

    public boolean dfs(TreeNode root, TreeNode target, TreeNode father) {
        if (root == null) {
            return false;
        }
        // 如果搜到了目标节点，那么它爸爸就是新树的根，
        if (root == target) {
            this.father = father;
            return true;
        }
        // 如果我成了左儿子的儿子，那我的爸爸就是我的新的左儿子
        if (dfs(root.left, target, root)) {
            root.left = father;
            return true;
        }
        // 如果我成了我右儿子的儿子，那我的爸爸就是我的新的右儿子
        if (dfs(root.right, target, root)) {
            root.right = father;
            return true;
        }
        // 递归的时候返回：爸爸
        return false;
    }

    public void search(TreeNode root, int depth, int K) {
        if (root == null) {
            return;
        }
        if (depth == K) {
            res.add(root.val);
        } else {
            search(root.left, depth + 1, K);
            search(root.right, depth + 1, K);
        }
    }
}
