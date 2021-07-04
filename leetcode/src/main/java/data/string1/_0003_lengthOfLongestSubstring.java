package data.string1;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 19:20
 * @Description:
 */
public class _0003_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        if (N <= 1) {
            return N;
        }

        Set<Character> set = new HashSet<>();
        int res = 0;

        char[] arr = s.toCharArray();
        int right = 0;
        for (int left = 0; left < N; left++) {
            while (right < N && !set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
            }
            res = Math.max(res, right - left);
            set.remove(s.charAt(left));
        }

        return res;
    }
}


