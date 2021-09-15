package data.stack;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 17:10
 * @Description:
 */
public class    _0844_backspaceCompare {

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        _0844_backspaceCompare solution = new _0844_backspaceCompare();

        System.out.println(solution.backspaceCompare(s, t));
    }


    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
