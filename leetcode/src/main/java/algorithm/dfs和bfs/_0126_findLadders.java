package algorithm.dfs和bfs;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 20:33
 * @Description:
 */
public class _0126_findLadders {

    public static void main(String[] args) {
        _0126_findLadders solution = new _0126_findLadders();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(solution.findLadders(beginWord, endWord, wordList));
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet= new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return new ArrayList<>();

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Deque<List<String>> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        path.add(beginWord);
        deque.add(path);
        visited.add(beginWord);

        boolean isFound = false;
        while (!deque.isEmpty()) {
            Set<String> levelVisited = new HashSet<>();         // 本层访问过的节点
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                path = deque.removeFirst();
                String cur = path.get(path.size() - 1);             // 取最后一位
                List<String> nextList = getNext(wordSet, cur);

                for (String next : nextList) {
                    if (visited.contains(next)) continue;
                    path.add(next);
                    levelVisited.add(next);
                    deque.addLast(new ArrayList<>(path));
                    if (next.equals(endWord)) {
                        res.add(new ArrayList<>(path));
                        isFound = true;
                    }
                    path.remove(path.size() - 1);
                }
            }
            visited.addAll(levelVisited);
            if (isFound) return res;
        }
        return res;
    }

    private List<String> getNext(Set<String> wordSet, String cur) {
        List<String> nextList = new ArrayList<>();
        char[] arr = cur.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char originChar = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String next = new String(arr);
                if (wordSet.contains(next)) {
                    nextList.add(next);
                }
            }
            arr[i] = originChar;
        }
        return nextList;
    }
}
