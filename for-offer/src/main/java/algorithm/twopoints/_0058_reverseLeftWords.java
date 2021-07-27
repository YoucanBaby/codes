package algorithm.twopoints;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoints
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 01:45
 * @Description:
 */
public class _0058_reverseLeftWords {

    public String reverseLeftWords(String s, int k) {
        int N = s.length();
        k %= N;

        String str1 = s.substring(0, k);
        String str2 = s.substring(k, N);

        return str2 + str1;
    }
}
