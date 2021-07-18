package odd._250;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._250
 * @Author: xuyifang
 * @CreateTime: 2021-07-18 10:31
 * @Description:
 */
public class _5161_canBeTypedWords {

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            }
        }

        int count = 0;
        for (String s : text.split(" ")) {
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    count--;
                    break;
                }
            }
            count++;
        }

        return count;
    }
}
