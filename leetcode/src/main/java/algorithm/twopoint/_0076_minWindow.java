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

        int[] needs = new int[128];         //  t中每个字符的个数
        for (char c: t.toCharArray()) {
            needs[c]++;
        }
        int[] window = new int[128];        // 滑动窗口中每个字符的个数

        int count = 0;                      // 滑动窗口包含t中字符的有效个数
        int minLength = Integer.MAX_VALUE;  // 最短的合格子串长度
        String res = "";

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c]++;
            if (needs[c] > 0 && needs[c] >= window[c]) {        // 如果右指针是我们需要的字符，count++
                count++;
            }

            while (count == t.length()) {
                c = s.charAt(left);
                if (needs[c] > 0 && needs[c] >= window[c]) {    // 如果左指针是我们需要的字符，count--
                    count--;
                }
                if (minLength > right - left + 1) {             // 记录最短的字串，更新window，
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[c]--;        // 更新最小长度，左指针向左移一位
                left++;
            }
        }
        return res;
    }
}
