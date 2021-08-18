package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-16 14:49
 * @Description:
 */
public class _0424_characterReplacement {

    public int characterReplacement(String s, int k) {
        int[] window = new int[128];
        int historyMaxFreq = 0;       // 以往窗口中出现最多次的字符
        int res = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right)]++;
            historyMaxFreq = Math.max(historyMaxFreq, window[s.charAt(right)]);

            while (right - left + 1 > historyMaxFreq + k) {
                window[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
