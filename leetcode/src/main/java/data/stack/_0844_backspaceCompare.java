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
        System.out.println(solution.backspaceCompare2(s, t));
    }

    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;              // s中需要跳过的字符个数
        int skipT = 0;              // t中需要跳过的字符个数

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }


    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '#') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
}
