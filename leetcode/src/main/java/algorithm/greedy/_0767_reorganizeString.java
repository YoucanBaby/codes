package algorithm.greedy;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-23 13:08
 * @Description:
 */
public class _0767_reorganizeString {

    public static void main(String[] args) {
        _0767_reorganizeString solution = new _0767_reorganizeString();

        String s = "bfrbs";
        System.out.println(solution.reorganizeString(s));
    }


    public String reorganizeString(String ss) {
        char[] s = ss.toCharArray();
        int[] count = new int[26];
        for (char c : s) {
            count[c - 'a']++;
        }

        int maxCount = 0;
        int maxAlpha = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlpha = i;
            }
        }
        if (maxCount > (s.length + 1) / 2) return "";

        char[] res = new char[s.length];
        int index = 0;
        while (count[maxAlpha]-- > 0) {
            res[index] = (char) (maxAlpha + 'a');
            index += 2;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (index >= res.length) index = 1;
                res[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(res);
    }
}
