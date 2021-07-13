package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 16:13
 * @Description:
 */
public class _0078_subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        _0078_subsets solution = new _0078_subsets();

        System.out.println(solution.subsets(nums));
        System.out.println(solution.subsets1(nums));
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int N = nums.length;

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        recursion(0, nums, res);
        return res;
    }

    public void recursion(int i, int[] nums, List<List<Integer>> res) {
        // 终止条件
        if (i >= nums.length) {
            return;
        }
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> temp = new ArrayList<>(res.get(j));
            temp.add(nums[i]);
            res.add(temp);
        }
        recursion(i + 1, nums, res);
    }
}
