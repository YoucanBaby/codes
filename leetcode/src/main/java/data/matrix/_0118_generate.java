package data.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 14:24
 * @Description:
 */
public class _0118_generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int a = lists.get(i - 1).get(j - 1);
                    int b = lists.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
