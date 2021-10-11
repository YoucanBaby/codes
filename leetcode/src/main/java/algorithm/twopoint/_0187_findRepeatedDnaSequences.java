package algorithm.twopoint;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 12:12
 * @Description:
 */
public class _0187_findRepeatedDnaSequences {


    public List<String> findRepeatedDnaSequences(String s) {
        char[] map = new char[128];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();

        if (s.length() < 10) return new ArrayList<>();
        int key = 0;
        for (int i = 0; i < 10; i++) {
            key <<= 2;
            key |= map[s.charAt(i)];
        }
        set.add(key);

        for (int i = 10; i < s.length(); i++) {
            key <<= 2;
            key |= map[s.charAt(i)];
            key &= 0xFFFFF;
            if (!set.contains(key)) set.add(key);
            else res.add(s.substring(i - 9, i + 1));
        }
        return new ArrayList<>(res);
    }


    public List<String> findRepeatedDnaSequences1(String s) {
        if (s.length() < 10) return new ArrayList<>();

        char[] map = new char[128];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();

        int key = 0;
        for (int i = 0; i < 10; i++) {
            key <<= 2;
            key |= map[s.charAt(i)];
        }
        set.add(key);

        for (int i = 10; i < s.length(); i++) {
            key <<= 2;
            key |= map[s.charAt(i)];
            key &= 0xFFFFF;
            if (!set.contains(key)) set.add(key);
            else res.add(s.substring(i - 9, i + 1));
        }
        return new ArrayList<>(res);
    }
}






