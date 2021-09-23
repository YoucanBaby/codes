package algorithm.math;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 11:41
 * @Description:
 */
public class _0043_multiply {



    public String multiply(String num1, String num2) {
        int M = num1.length(), N = num2.length();
        int[] res = new int[M + N];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int p1 = i + j, p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        int i = 0;
        while (i < res.length && res[i] == 0) i++;
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < res.length; j++) sb.append(res[j]);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
