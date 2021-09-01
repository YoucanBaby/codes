package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 01:38
 * @Description:
 */
public class _0784_letterCasePermutation {



    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        dfs(res, arr, 0);
        return res;
    }

    private void dfs(List<String> res, char[] arr, int index) {
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }

        dfs(res, arr, index + 1);
        if (Character.isLetter(arr[index])) {
            arr[index] ^= (1 << 5);
            dfs(res, arr, index + 1);
        }
    }
}
