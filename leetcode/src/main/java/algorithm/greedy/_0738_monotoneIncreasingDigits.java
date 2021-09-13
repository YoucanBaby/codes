package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 20:29
 * @Description:
 */
public class _0738_monotoneIncreasingDigits {

    public static void main(String[] args) {
        int N = 15243;
        _0738_monotoneIncreasingDigits solution = new _0738_monotoneIncreasingDigits();

        System.out.println(solution.monotoneIncreasingDigits(N));
    }


    public int monotoneIncreasingDigits1(int n) {
        char[] s = String.valueOf(n).toCharArray();

        int start = s.length;
        for (int i = s.length - 2; i >= 0; i--) {
            if (s[i] > s[i + 1]) {
                s[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < s.length; i++) {
            s[i] = '9';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        return Integer.valueOf(sb.toString());
    }



    public int monotoneIncreasingDigits(int n) {
        int ones = 111111111;
        int res = 0;
        for (int i = 0; i < 9; i++) {
            while (res + ones > n) {
                ones /= 10;
            }
            res += ones;
        }
        return res;
    }
}
