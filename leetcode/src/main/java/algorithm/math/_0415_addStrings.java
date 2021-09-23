package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 20:06
 * @Description:
 */
public class _0415_addStrings {


    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? num1.charAt(i) - '0' : 0;
            sum += j >= 0 ? num2.charAt(j) - '0' : 0;
            res.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) res.append("1");
        return res.reverse().toString();
    }
}
