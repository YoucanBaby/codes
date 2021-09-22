package data.hashtable1;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-09-22 11:50
 * @Description:
 */
public class _0804_uniqueMorseRepresentations {


    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                "..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(MORSE[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
