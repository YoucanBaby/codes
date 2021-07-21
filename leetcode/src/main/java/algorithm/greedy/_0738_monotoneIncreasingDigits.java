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


    public int monotoneIncreasingDigits(int N) {
        char[] arr = String.valueOf(N).toCharArray();

        int start = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                arr[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < arr.length; i++) {
            arr[i] = '9';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return Integer.valueOf(sb.toString());
    }
}
