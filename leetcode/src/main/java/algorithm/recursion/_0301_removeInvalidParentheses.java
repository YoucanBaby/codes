package algorithm.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 04:56
 * @Description:
 */
public class _0301_removeInvalidParentheses {

    char[] arr;
    StringBuilder path = new StringBuilder();
    Set<String> res = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        arr = s.toCharArray();

        // 计算多余的左右括号
        int leftRemove = 0;
        int rightRemove = 0;
        for (char c : arr) {
            if (c == '(') {
                leftRemove++;
            } else if (c == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                }
                if (leftRemove > 0) {
                    leftRemove--;       // 一个右括号出现可以抵销之前遇到的左括号
                }
            }
        }

        dfs(0, 0, 0, leftRemove, rightRemove);
        return new ArrayList<>(res);
    }

    /**
     *
     * @param index         当前遍历到的下标
     * @param leftCount     已经遍历到的左括号的个数
     * @param rightCount    已经遍历到的右括号的个数
     * @param leftRemove    最少应该删除的左括号的个数
     * @param rightRemove   最少应该删除的右括号的个数
     */
    public void dfs(int index, int leftCount, int rightCount, int leftRemove, int rightRemove) {
        if (index == arr.length) {
            if (leftRemove == 0 && rightRemove == 0) {
                res.add(path.toString());
            }
            return;
        }

        char c = arr[index];
        // 操作1：删除当前遍历到的字符
        // 删除左括号
        if (c == '(' && leftRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove);
        }
        // 删除右括号
        if (c == ')' && rightRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1);
        }
        // 操作2：保留当前遍历到的字符
        path.append(c);
        if (c == '(') {
            dfs(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove);
        } else if (c == ')' && leftCount > rightCount) {
            // 遍历到右括号，并且左括号数量大于右括号数量
            dfs(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove);
        } else if (c != '(' && c != ')'){
            // 如果遍历到的不是括号，而是字母
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove);
        }
        path.deleteCharAt(path.length() - 1);   // 回溯
    }
}
