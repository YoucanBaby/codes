package algorithm.twopoint;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-11 15:11
 * @Description:
 */
public class _0567_checkInclusion {


    public boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
        }
        
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            freq[s2.charAt(right)]--;
            while (freq[s2.charAt(right)] < 0) {
                freq[s2.charAt(left)]++;
                left++;
            }
            if (right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }


    public boolean checkInclusion1(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        if (M > N) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < M; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count1, count2)) {
            return true;
        }

        for (int i = M; i < N; i++) {
            count2[s2.charAt(i - M) - 'a']--;
            count2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        if (M > N) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < M; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        // 变量diff 记录count值 不为0的个数
        int diff = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }

        for (int i = M; i < N; i++) {
            int left = s2.charAt(i - M) - 'a';
            int right = s2.charAt(i) - 'a';
            if (left == right) {
                continue;
            }
            // 左边
            if (count[left] == 0) {
                diff++;
            }
            count[left]++;
            if (count[left] == 0) {
                diff--;
            }
            // 右边
            if (count[right] == 0) {
                diff++;
            }
            count[right]--;
            if (count[right] == 0) {
                diff--;
            }

            if (diff == 0) {
                return true;
            }
        }

        return false;
    }

}
