package data.stack;

import javax.xml.transform.Result;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 14:01
 * @Description:
 */
public class _0071_simplifyPath {

    public static void main(String[] args) {
        String path = "/home//foo/";
        _0071_simplifyPath solution = new _0071_simplifyPath();

        System.out.println(solution.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.equals("") ? "/" : res;
    }
}
