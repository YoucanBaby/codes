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

        while (n != 0) {
            int num = n % 26;
            if (num == 0) {
                num = 26;
                n--;
            }
            sb.insert(0, (char) ('A' + num - 1));
            n /= 26;
        }
        return sb.toString();
    }
}
