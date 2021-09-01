package algorithm.recursion;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 00:46
 * @Description:
 */
public class _0127_ladderLength {

    int res = Integer.MAX_VALUE;
    int count = 1;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] used = new boolean[wordList.size()];
        dfs(wordList, used, endWord, beginWord);

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private void dfs(List<String> wordList, boolean[] used, String endWord, String nowWord) {
        if (nowWord.equals(endWord)) {
            res = Math.min(res, count);
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (used[i]) {
                continue;
            }
            if (isSameWord(wordList.get(i), nowWord)) {
                used[i] = true;
                count++;
                dfs(wordList, used, endWord, wordList.get(i));
                count--;
                used[i] = false;
            }
        }
    }

    private boolean isSameWord(String s, String t) {
        int diffCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount <= 1;
    }
}
