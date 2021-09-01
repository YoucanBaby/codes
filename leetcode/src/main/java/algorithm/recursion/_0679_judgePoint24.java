package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 03:01
 * @Description:
 */
public class _0679_judgePoint24 {

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }

        return dfs(list);
    }

    public boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= 0.0000000001;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j);
                double a = copy.remove(i);
                boolean valid = false;

                copy.add(a + b);
                valid |= dfs(copy);

                copy.set(copy.size() - 1, a - b);
                valid |= dfs(copy);

                copy.set(copy.size() - 1, a / b);
                valid |= dfs(copy);

                copy.set(copy.size() - 1, a * b);
                valid |= dfs(copy);

                copy.set(copy.size() - 1, b - a);
                valid |= dfs(copy);

                copy.set(copy.size() - 1, b / a);
                valid |= dfs(copy);

                if (valid) {
                    return true;
                }
            }
        }
        return false;
    }
}
