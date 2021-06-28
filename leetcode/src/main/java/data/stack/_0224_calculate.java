package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 23:51
 * @Description:
 */
public class _0224_calculate {

    public static void main(String[] args) {
        String s = "(1 + (4 - (5 - 22)) - (6 + 8))";
        _0224_calculate solution = new _0224_calculate();

        System.out.println((1 + (4 - (5 - 22)) - (6 + 8)));
        System.out.println(solution.calculate(s));
    }

    public int calculate(String s) {
        Deque<Integer> stNum = new LinkedList<>();      // 存储 左括号外面已经算过的结果ret
        Deque<Integer> stSign = new LinkedList<>();     // 存储 左括号前面的符号sign
        int ret = 0;        // 上一个数字或当前数字
        int sign = 1;       // 上一个符号或当前符号

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {     // 遇到 '空格' ，则直接跳过
                continue;
            } else if (c == '+' || c == '-') {  // 遇到正负号，则更新符号 sign
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
            } else if (c >= '0' && c <= '9') {  // 遇到连续的数字，则算出这个数字，更新 ret
                int num = s.charAt(i) - '0';
                while ((i+1) < s.length() && s.charAt(i+1) <= '9' && s.charAt(i+1) >= '0') {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                ret += sign * num;
            } else if (c == '(') {  // 遇到左括号
                stNum.push(ret);    // 则将 左括号外面已经算过的结果ret 和 括号前面的符 sign入栈
                stSign.push(sign);
                ret = 0;            // 并更新 ret = 0 和 sign = 1
                sign = 1;
            } else if (c == ')') {  // 遇到右括号，则出栈，更新结果ret（计算括号内的值）
                ret = stNum.pop() + stSign.pop() * ret;
            }
        }
        return ret;
    }
}
