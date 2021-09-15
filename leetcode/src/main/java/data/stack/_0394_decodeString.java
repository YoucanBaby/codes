package data.stack;

import java.util.ArrayDeque;
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
        int num = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> sbStack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (Character.isLowerCase(c)) {
                sb.append(c);
            } else if (c == '[') {
                numStack.push(num);
                sbStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int curNum = numStack.pop();
                StringBuilder temp = new StringBuilder();
                while (curNum-- > 0) {
                    temp.append(sb);
                }
                sb = sbStack.pop().append(temp);      // sb = sbStack.pop() + sb * numStack.pop()
            }
        }
        return sb.toString();
    }
}
