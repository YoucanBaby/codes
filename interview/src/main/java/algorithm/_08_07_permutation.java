package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 10:27
 * @Description:
 */
public class _08_07_permutation {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public String[] permutation(String str) {
        boolean[] used = new boolean[str.length()];
        dfs(str, used);

        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public void dfs(String str, boolean[] used) {
        if (path.length() == str.length()) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i]) {
                continue;
            }

            path.append(str.charAt(i));
            used[i] = true;
            dfs(str, used);
            used[i] =false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
