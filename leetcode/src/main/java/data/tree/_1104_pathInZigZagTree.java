package data.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-29 00:46
 * @Description:
 */
public class _1104_pathInZigZagTree {

    public static void main(String[] args) {
        int target = 14;
        _1104_pathInZigZagTree solution = new _1104_pathInZigZagTree();

        System.out.println(solution.pathInZigZagTree(target));
    }

    public List<Integer> pathInZigZagTree(int target) {
        List<Integer> res = new ArrayList<>();
        int depth = (int) (Math.log(target) / Math.log(2)) + 1;     // ln(target) / ln(2)

        // 每上一层，反转一次
        while (target > 1) {
            res.add(0, target);
            target = target / 2;
            depth--;
            // 上一层最右边和最左边的值
            int right = (int) (Math.pow(2, depth) - 1);
            int left = (int) (Math.pow(2, depth - 1));
            // 反转
            target = right - (target - left);
        }
        res.add(0, 1);      // 加入根节点

        return res;
    }
}
