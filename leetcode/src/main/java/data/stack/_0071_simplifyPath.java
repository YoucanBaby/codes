package data.stack;

import javax.xml.transform.Result;
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
        String path = "/a/./b/../../c/";
        _0071_simplifyPath solution = new _0071_simplifyPath();

        System.out.println(solution.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();

        System.out.println(Arrays.toString(path.split("/")));

        for (String s: path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeFirst();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.addFirst(s);
            }
        }

        String ret = "";
        for (String d :stack) {
            ret = "/" + d + ret;
        }
        if (!ret.isEmpty()) return ret;
        else return "/";
    }
}
