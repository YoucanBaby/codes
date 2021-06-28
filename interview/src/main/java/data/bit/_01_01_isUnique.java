package data.bit;

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

    public boolean isUnique(String astr) {
        int mark = 0;

        for (char c: astr.toCharArray()) {
            int moveBit = c - 'a';

            if ((mark & (1 << moveBit)) != 0) {
                return false;
            } else {
                mark = mark | (1 << moveBit);
            }
        }

        return true;
    }
}
