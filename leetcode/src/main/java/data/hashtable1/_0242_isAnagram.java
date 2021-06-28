package data.hashtable1;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 20:35
 * @Description:
 */
public class _0242_isAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        _0242_isAnagram solution = new _0242_isAnagram();

        System.out.println(solution.isAnagram(s,t));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
