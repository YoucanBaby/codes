package odd._260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._260
 * @Author: xuyifang
 * @CreateTime: 2021-09-26 11:40
 * @Description:
 */
public class _5883_placeWordInCrossword {

    public static void main(String[] args) {
        _5883_placeWordInCrossword solution = new _5883_placeWordInCrossword();

//        char[][] mat = {
//                {' ', '#', 'a'},
//                {' ', '#', 'c'},
//                {' ', '#', 'a'}
//        };
//        String s = "ac";
        char[][] mat = {
                {'#', ' ', '#'},
                {'#', ' ', '#'},
                {'#', ' ', 'c'}
        };
        String s = "ca";

        System.out.println(solution.placeWordInCrossword(mat, s));
    }

    public boolean placeWordInCrossword(char[][] mat, String s) {
        char[][] newMat = getT(mat);
        return check(mat, s) || check(newMat, s);
    }

    private boolean check(char[][] mat, String s) {
        int M = mat.length;
        int N = mat[0].length;
        for (int i = 0; i < M; i++) {
            List<Integer> list = new ArrayList<>();     // 放'#'的下标
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == '#') {
                    list.add(j);
                }
            }
            if (list.size() == 0) {
                if (N == s.length()) {
                    String t = new String(Arrays.copyOfRange(mat[i], 0, N));
                    if (isVaild(s, t)) return true;
                }
                continue;
            }

            if (list.get(0) - 0 == s.length()) {
                String t = new String(Arrays.copyOfRange(mat[i], 0, list.get(0)));
                if (isVaild(s, t)) return true;
            }
            if (N - list.get(list.size() - 1) - 1 == s.length()) {
                String t = new String(Arrays.copyOfRange(mat[i], list.get(list.size() - 1) + 1, N));
                if (isVaild(s, t)) return true;
            }
            for (int k = 1; k < list.size(); k++) {
                if (list.get(k) - list.get(k - 1) - 1 == s.length()) {
                    String t = new String(Arrays.copyOfRange(mat[i], list.get(k - 1) + 1, list.get(k)));
                    if (isVaild(s, t)) return true;
                }
            }
        }
        return false;
    }

    private boolean isVaild(String s, String t) {
        int N = t.length();
        if (N == 0) return false;

        boolean res = false;
        int i = 0;
        while (i < N) {
            if (t.charAt(i) != ' ' && s.charAt(i) != t.charAt(i)) break;
            i++;
        }
        if (i == N) res |= true;

        i = N - 1;
        while (i >= 0) {
            if (t.charAt(i) != ' ' && s.charAt(N - i - 1) != t.charAt(i)) break;
            i--;
        }
        if (i == -1) res |= true;

        return res;
    }

    private char[][] getT(char[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        char[][] res = new char[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[j][i] = mat[i][j];
            }
        }
        return res;
    }
}
