package data.string1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-09-26 07:09
 * @Description:
 */
public class _0820_minimumLengthEncoding {

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        Trie trie = new Trie();
        int res = 0;
        for (String s : words) {
            res += trie.insert(s);
        }
        return res;
    }

    class Trie {

        int N = (int) 1e5;
        int[][] trie = new int[N][26];
        int index = 1;

        public Trie() {}

        public int insert(String s) {
            boolean isNew = false;
            int p = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int c = s.charAt(i) - 'a';
                if (trie[p][c] == 0) {
                    isNew = true;
                    trie[p][c] = index++;
                }
                p = trie[p][c];
            }
            return isNew ? s.length() + 1 : 0;
        }
    }
}
