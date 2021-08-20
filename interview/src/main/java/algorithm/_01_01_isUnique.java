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

    public boolean isUnique(String strs) {
        int mark = 0;
        for (char c: strs.toCharArray()) {
            int bitIndex = 1 << (c - 'a');
            if ((mark & bitIndex) != 0) {
                return false;
            } else {
                mark |= bitIndex;
            }
        }
        return true;
    }
}
