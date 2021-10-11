package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-10-07 13:57
 * @Description:
 */
public class _0434_countSegments {



    public int countSegments(String s) {
        int count = 0;
        for (String t : s.split(" ")) {
            if (!t.equals("")) count++;
        }
        return count;
    }
}
