package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-23 13:08
 * @Description:
 */
public class _0767_reorganizeString {

    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        // 统计每个字符出现的频率
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'a']++;
        }
        // 找出出现频率最大的字符，如果超过临界值，就返回“空字符串”
        int maxFreq = 0;
        int maxAlpha = 0;
        int threshold = (arr.length + 1) / 2;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxFreq) {
                maxFreq = Math.max(maxFreq, count[i]);
                maxAlpha = i;
                if (maxFreq > threshold) {
                    return "";
                }
            }
        }
        // 把出现次数最多的字符存储在数组下标为偶数的位置上
        char[] res = new char[arr.length];
        int index = 0;
        while (count[maxAlpha] > 0) {
            res[index] = (char) ('a' + maxAlpha);
            index += 2;
            count[maxAlpha]--;
        }
        // 再把剩下的字符存储在其他位置上
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) ('a' + i);
                index += 2;
                count[i]--;
            }
        }
        return new String(res);
    }
}
