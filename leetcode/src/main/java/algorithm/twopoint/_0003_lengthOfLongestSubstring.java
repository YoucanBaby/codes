package algorithm.twopoint;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 16:16
 * @Description:
 */
public class _0003_lengthOfLongestSubstring {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        if (N <= 1) {
            return N;
        }

        Set<Character> set = new HashSet<>();
        int right = 0;
        int ret = 0;
        for (int left = 0; left < N; left++) {
            while (right < N && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            ret = Math.max(ret, right - left);
            set.remove(s.charAt(left));
        }
        return ret;
    }
}
