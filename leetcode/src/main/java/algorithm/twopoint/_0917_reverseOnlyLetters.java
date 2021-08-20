package algorithm.twopoint;

import javax.xml.stream.events.Characters;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 23:37
 * @Description:
 */
public class _0917_reverseOnlyLetters {


    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(j))) {
                    j--;
                }
                sb.append(s.charAt(j--));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
