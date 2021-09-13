package algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-20 16:36
 * @Description:
 */
public class _0179_largestNumber {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        _0179_largestNumber solution = new _0179_largestNumber();

        System.out.println(solution.largestNumber(nums));
    }


    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }

        int i = 0;
        while (i < s.length - 1 && sb.charAt(i) == '0') {
            i++;
        }
        return sb.substring(i);
    }
}
