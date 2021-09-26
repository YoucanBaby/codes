package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 05:39
 * @Description:
 */
public class _0383_canConstruct {

    public boolean canConstruct(String r, String m) {
        int[] freq = new int[128];
        for (char c : m.toCharArray()) freq[c]++;
        for (char c : r.toCharArray()) {
            freq[c]--;
            if (freq[c] < 0) return false;
        }
        return true;
    }
}
