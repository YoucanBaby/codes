package algorithm.math;

/**
 * @BelongsProject: interview
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-06-29 01:18
 * @Description:
 */
public class _0168_convertToTitle {

    public static void main(String[] args) {

    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int num = n % 26;
            sb.insert(0, (char) ('A' + num));
            n /= 26;
        }
        return sb.toString();
    }
}
