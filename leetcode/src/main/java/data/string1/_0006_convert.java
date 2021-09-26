package data.string1;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-09-25 03:09
 * @Description:
 */
public class _0006_convert {


    public String convert(String s, int numRows) {
        if (numRows < 2) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int i = 0, step = -1;
        for (char c : s.toCharArray()) {
            rows[i].append(c);
            if (i == 0 || i == numRows - 1) step = -step;
            i += step;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
