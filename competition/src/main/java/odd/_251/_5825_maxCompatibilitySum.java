package odd._251;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._251
 * @Author: xuyifang
 * @CreateTime: 2021-07-25 10:57
 * @Description:
 */
public class _5825_maxCompatibilitySum {


    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int M = students.length;
        int N = students[0].length;

        int[] nums = new int[M];
        for (int i = 0; i < M; i++) {
            nums[i] = i;
        }
        // 获得导师下标的全排列
        List<List<Integer>> mentorsList = permute(nums);

        int res = 0;
        for (List<Integer> mentorList : mentorsList) {
            int sum = 0;
            int studentIdx = 0;

            for (int i = 0; i < M; i++) {
                int mentorIdx = mentorList.get(i);  // 导师下标

                for (int j = 0; j < N; j++) {
                    if (students[studentIdx][j] == mentors[mentorIdx][j]) {
                        sum++;
                    }
                }
                studentIdx++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int N = nums.length;
        boolean[] used = new boolean[N];

        dfs(nums, used);
        return res;
    }

    public void dfs(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
