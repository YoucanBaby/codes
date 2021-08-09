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

    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for (char c : arr) {
            freq[c - 'a']++;
        }
        // 找出出现频率最大的字符，如果超过临界值，就返回“空字符串”
        int maxFreq = 0;
        int maxAlpha = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxAlpha = i;
                if (maxFreq > (arr.length + 1) / 2) {
                    return "";
                }
            }
        }
        // 把出现次数最多的字符存储在数组下标为偶数的位置上
        char[] res = new char[arr.length];
        int index = 0;
        while (freq[maxAlpha] > 0) {
            res[index] = (char) (maxAlpha + 'a');
            freq[maxAlpha]--;
            index += 2;
        }
        // 再把剩下的字符存储在其他位置上
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                freq[i]--;
                index += 2;
            }
        }
        return new String(res);
    }
}
