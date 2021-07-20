package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 19:19
 * @Description:
 */
public class _08_08_permutation {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    boolean[] used;

    public String[] permutation(String S) {
        used = new boolean[S.length()];
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        dfs(arr);

        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public void dfs(char[] arr) {
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
                dfs(arr);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
