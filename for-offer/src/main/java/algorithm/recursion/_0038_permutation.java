package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 16:39
 * @Description:
 */
public class _0038_permutation {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public String[] permutation(String str) {
        boolean[] used = new boolean[str.length()];
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        dfs(arr, used);

        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public void dfs(char[] arr, boolean[] used) {
        if (path.length() == arr.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && used[i - 1] == true) {
                continue;
            }
            if (used[i] == false) {
                path.append(arr[i]);
                used[i] = true;
                dfs(arr, used);
                used[i] =false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
