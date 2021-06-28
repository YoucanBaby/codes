package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-13 01:01
 * @Description:
 */
public class _0394_decodeString {

    public static void main(String[] args) {
        String s = "ab2[abc]3[cd]ef";
        _0394_decodeString solution = new _0394_decodeString();

        System.out.println(solution.decodeString(s));
    }

    public String decodeString(String s) {
        // 构建辅助栈 stkNum 和 stkRes
        Deque<Integer> stkNum = new LinkedList<>();
        Deque<String> stkRes = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {     // 当c为数字时，算出连续数字的值，用 int num 保存
                num = c - '0';
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            } else if (c >= 'a' && c <= 'z') {  // 当 c 为字母时，在 res 尾部添加 c；
                res.append(c);
            } else if (c == '[') {      // 当 c 为 [ 时，将当前 num 和 res 入栈，并分别 置 0 置 null：
                stkNum.push(num);
                stkRes.push(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {      // 当 c 为 ] 时，stack 出栈，拼接字符串 res = lastRes + curNum  * res，
                int curNum = stkNum.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < curNum; j++) {
                    temp.append(res);
                }
                String lastRes = stkRes.pop();
                res = new StringBuilder(lastRes + temp);
            }
        }
        return res.toString();
    }
}
