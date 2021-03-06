package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 03:41
 * @Description:
 */
public class _0773_slidingPuzzle {

    public static void main(String[] args) {
        int[][] board = {
                {1,2,3},
                {4,0,5}
        };
        _0773_slidingPuzzle solution = new _0773_slidingPuzzle();

        System.out.println(solution.slidingPuzzle(board));
    }

    int[][] neighbors = {
            {1, 3}, {0, 2, 4}, {1, 5},      // 第0行
            {0, 4}, {1, 3, 5}, {2, 4}       // 第1行
    };

    public int slidingPuzzle(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char c = (char) (mat[i][j] + '0');
                sb.append(c);
            }
        }
        String src = sb.toString();
        if (src.equals("123450")) {
            return 0;
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(src);
        Map<String, Integer> visited = new HashMap();
        visited.put(src, 0);

        while (!deque.isEmpty()) {
            String cur = deque.removeFirst();
            List<String> nextList = getNext(cur);

            for (String next : nextList) {
                if (!visited.containsKey(next)) {
                    deque.addLast(next);
                    visited.put(next, visited.get(cur) + 1);

                    if (next.equals("123450")) {
                        return visited.get(next);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> getNext(String cur) {
        List<String> nextList = new ArrayList<>();
        int i = cur.indexOf('0');
        for (int j : neighbors[i]) {
            char[] next = cur.toCharArray();
            swap(next, i, j);
            nextList.add(new String(next));
        }
        return nextList;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
