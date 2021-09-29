package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-09-20 01:40
 * @Description:
 */
public class _0409_longestPalindrome {


    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int res = 0;
        for (int f : freq) {
            if ((f & 1) == 0) res += f;
            else res += f - 1;
        }
        return res < s.length() ? res + 1 : res;
    }
}
