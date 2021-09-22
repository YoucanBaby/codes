package data.hashtable1;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-09-21 19:04
 * @Description:
 */
public class _0299_getHint {

    public static void main(String[] args) {
        _0299_getHint solution = new _0299_getHint();

        String s = "1123";
        String g = "0111";
        System.out.println(solution.getHint(s, g));
    }

    public String getHint(String s, String g) {
        int[] freq = new int[10];
        int A = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == g.charAt(i)) {
                A++;
                continue;
            }
            freq[s.charAt(i) - '0']++;
            freq[g.charAt(i) - '0']--;
        }

        System.out.println(Arrays.toString(freq));
        int sum = 0;
        for (int f : freq) {
            if (f > 0) sum += f;
        }
        int B = s.length() - sum - A;
        String res = A + "A" + B + "B";
        return res;
    }
}
