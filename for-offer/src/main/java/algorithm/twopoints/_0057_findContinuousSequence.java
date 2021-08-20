package algorithm.twopoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoints
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 00:58
 * @Description:
 */
public class _0057_findContinuousSequence {

    public static void main(String[] args) {
        int target = 9;
        _0057_findContinuousSequence solution = new _0057_findContinuousSequence();
        int[][] nums = solution.findContinuousSequence(target);

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        for (int right = 1; right < target; right++) {
            sum += right;
            while (sum > target) {
                sum -= left;
                left++;
            }
            if (sum == target && right - left + 1 >= 2) {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
            }
        }

        return res.toArray(new int[0][0]);
    }

    public int[][] findContinuousSequence1(int target) {
        List<int[]> res = new ArrayList<>();
        int sum = 0;

        int left = 1;
        for (int right = 1; right < target; right++) {
            sum += right;
            while (sum > target) {
                sum -= left;
                left++;
            }
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
