package algorithm.twopoint;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 17:50
 * @Description:
 */
public class _0076_minWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        _0076_minWindow solution = new _0076_minWindow();

        System.out.println(solution.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 统计 t 中字符出现的个数
        int[] needs = new int[128];
        for (char c: t.toCharArray()) {
            needs[c]++;
        }
        int[] window = new int[128];

        int left = 0;
        int right = 0;
        int count = 0;
        String ret = "";
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (needs[c] > 0 && needs[c] >= window[c]) {
                count++;
            }

            while (count == t.length()) {
                c = s.charAt(left);
                if (needs[c] > 0 && needs[c] >= window[c]) {
                    count--;
                }

                if (minLength > right - left + 1) {
                    ret = s.substring(left, right + 1);
                    minLength = right - left + 1;
                }
                window[c]--;
                left++;
            }
            right++;
        }

        return ret;
    }
}
