package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-23 01:17
 * @Description:
 */
public class _0678_checkValidString {

    public boolean checkValidString(String s) {
        int N = s.length();
        int left = 0, right = 0;
        for (int i = 0; i < N; i++) {
            left += s.charAt(i) == ')' ? -1 : + 1;
            right += s.charAt(N - 1 - i) == '(' ? -1 : + 1;
            if (left < 0 || right < 0) return false;
        }
        return true;
    }
}
