package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-06 05:47
 * @Description:
 */
public class _0120_minimumTotal {

    public static void main(String[] args) {
        _0120_minimumTotal solution = new _0120_minimumTotal();
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(2);
        triangle.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        triangle.add(temp);

        temp = new ArrayList<>();
        temp.add(6);
        temp.add(5);
        temp.add(7);
        triangle.add(temp);

        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        temp.add(8);
        temp.add(3);
        triangle.add(temp);

        System.out.println(solution.minimumTotal(triangle));
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int a = j - 1 < 0 ? Integer.MAX_VALUE : dp[j - 1] + triangle.get(i).get(j);
                int b = j >= triangle.get(i - 1).size() ? Integer.MAX_VALUE : dp[j] + triangle.get(i).get(j);
                dp[j] = Math.min(a, b);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}
