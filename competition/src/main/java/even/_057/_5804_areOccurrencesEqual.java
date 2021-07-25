package even._057;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._057
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 22:31
 * @Description:
 */
public class _5804_areOccurrencesEqual {

    public boolean areOccurrencesEqual(String s) {
        int[] counter = new int[26];
        char[] arr = s.toCharArray();

        for (char c : arr) {
            counter[c - 'a']++;
        }

        int count = 0;
        for (int num : counter) {
            if (num != 0) {
                count = num;
                break;
            }
        }


        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                continue;
            }
            if (counter[i] != count) {
                return false;
            }
        }

        return true;
    }
}
