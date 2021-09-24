package algorithm;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-09-22 13:08
 * @Description:
 */
public class _17_22_findLadders {

    public static void main(String[] args) {
        _17_22_findLadders solution = new _17_22_findLadders();

        String beginWord = "lost";
        String endWord = "miss";
        List<String> wordList = new ArrayList<>();
        wordList.add("lost");
        wordList.add("most");
        wordList.add("mist");
        wordList.add("fist");
        wordList.add("miss");

        System.out.println(solution.findLadders(beginWord, endWord, wordList));
    }


    // BFS
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return new ArrayList<>();

        List<String> path = new ArrayList<>();
        Deque<List<String>> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        path.add(beginWord);
        visited.add(beginWord);
        deque.offer(path);

        while (!deque.isEmpty()) {
            Set<String> levelVisited = new HashSet<>();
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                path = deque.poll();
                String cur = path.get(path.size() - 1);
                List<String> nextList = getNextList(set, cur);

                for (String next : nextList) {
                    if (visited.contains(next)) continue;
                    path.add(next);
                    levelVisited.add(next);
                    deque.offer(new ArrayList<>(path));
                    if (next.equals(endWord)) {
                        return path.size() == 1 && path.get(0) == beginWord ? new ArrayList<>() : path;
                    }
                    path.remove(path.size() - 1);
                }
            }
            visited.addAll(levelVisited);
        }
        return path.size() == 1 && path.get(0) == beginWord ? new ArrayList<>() : path;
    }

    private List<String> getNextList(Set<String> set, String cur) {
        List<String> nextList = new ArrayList<>();
        char[] arr = cur.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char originChar = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String next = new String(arr);
                if (set.contains(next)) {
                    nextList.add(next);
                }
            }
            arr[i] = originChar;
        }
        return nextList;
    }
}
