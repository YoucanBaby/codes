package algorithm;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.bit
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 05:35
 * @Description:
 */
public class _01_01_isUnique {

    public static void main(String[] args) {

    }

    public boolean isUnique(String s) {
        int mark = 0;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((mark & bit) != 0) return false;
            else mark |= bit;
        }
        return true;
    }
}
