package 建信金融科技专场竞赛;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: 建信金融科技专场竞赛
 * @author: xuyifang
 * @CreateTime: 2021-10-29-19:03
 * @description:
 * @version: 1.0
 */
public class _2 {


    public static void main(String[] args) {

    }


    public int[] analysisHistogram(int[] nums, int cnt) {
        Arrays.sort(nums);
        int N = nums.length;

        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < N - cnt; i++) {
            int num = nums[i + cnt - 1] - nums[i];
            if (num < min) {
                min = num;
                res = i;
                System.out.println(res);
            }
        }

        return Arrays.copyOfRange(nums, res, res + cnt);
    }
}
