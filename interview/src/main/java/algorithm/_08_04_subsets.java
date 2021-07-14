package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 08:04
 * @Description:
 */
public class _08_04_subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        _08_04_subsets solution = new _08_04_subsets();

        System.out.println(solution.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int N = res.size();
            for (int i = 0; i < N; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}
