package fall;

/**
 * @BelongsProject: codes
 * @BelongsPackage: fall
 * @Author: xuyifang
 * @CreateTime: 2021-09-11 15:34
 * @Description:
 */
public class _1_minimumSwitchingTimes {

    public static void main(String[] args) {
        _1_minimumSwitchingTimes solution = new _1_minimumSwitchingTimes();

        int[][] s = {{2,2,2}, {0,0,0}, {0,0,0}};
        int[][] t = {{3,3,3}, {0,0,0}, {0,0,0}};
        System.out.println(solution.minimumSwitchingTimes(s, t));
    }

    public int minimumSwitchingTimes(int[][] s, int[][] t) {
        int M = s.length;
        int N = s[0].length;

        int[] freq = new int[(int) (1e4 + 10)];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                freq[s[i][j]]++;
                freq[t[i][j]]--;
            }
        }

        int res = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                res += freq[i];
            }
        }
        return res;
    }
}
