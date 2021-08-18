package algorithm.twopoint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 12:12
 * @Description:
 */
public class _0187_findRepeatedDnaSequences {


    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        char[] map = new char[128];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        int key = 0;
        // 第一组单独统计
        for (int i = 0; i < 10; i++) {
            key <<= 2;
            key |= map[s.charAt(i)];
        }
        set.add(key);
        // 统计剩余的
        for (int i = 10; i < s.length(); i++) {
            key <<= 2;
            key |= map[s.charAt(i)];
            key &= 0xfffff;                 // 10个字母，每个字母对应两位，我们只需要低20位
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }
        }
        return new ArrayList<>(res);
    }
}






