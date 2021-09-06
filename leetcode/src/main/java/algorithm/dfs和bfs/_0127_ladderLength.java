package algorithm.dfs和bfs;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 19:19
 * @Description:
 */
public class _0127_ladderLength {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        Deque<String> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        deque.addLast(beginWord);
        visited.add(beginWord);

        int step = 1;
        while (!deque.isEmpty()) {
            step++;
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                String curWord = deque.removeFirst();
                if (changeLetterIsEndWord(deque, visited, wordSet, endWord, curWord)) {
                    return step;
                }
            }
        }
        return 0;
    }

    private boolean changeLetterIsEndWord(Deque<String> deque, Set<String> visited,
                                          Set<String> wordSet, String endWord, String curWord) {

        char[] arr = curWord.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char originChar = arr[i];

            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String nextWord = new String(arr);
                if (!wordSet.contains(nextWord)) {
                    continue;
                }

                if (nextWord.equals(endWord)) {
                    return true;
                }
                if (!visited.contains(nextWord)) {
                    visited.add(nextWord);
                    deque.addLast(nextWord);
                }
            }
            arr[i] = originChar;
        }
        return false;
    }
}
