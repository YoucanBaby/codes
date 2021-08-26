package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 12:32
 * @Description:
 */
public class _0269_alienOrder {


    public static void main(String[] args) {
        _0269_alienOrder solution = new _0269_alienOrder();

        // String[] words = {"wrt","wrf","er","ett","rftt"};
        String[] words = {"abc","ab"};
        System.out.println(solution.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length()) {
                    return "";
                }
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                } else {
                    // 保存第一个不同的字符顺序
                    Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                    set.add(words[i + 1].charAt(j));
                    map.put(words[i].charAt(j), set);
                    break;
                }
            }
        }

        int[] inDegree = new int[128];           // 入度
        Arrays.fill(inDegree, - 1);         // 没有出现的字母入度为-1
        for (String word : words) {             // 出现的字母入度都为0
            for (char c : word.toCharArray()) {
                inDegree[c] = 0;
            }
        }
        for (char key : map.keySet()) {
            for (char val : map.get(key)) {
                inDegree[val]++;          // 统计入度
            }
        }

        StringBuilder sb = new StringBuilder();         // 拓扑排序的结果
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;                                  // 图中节点数
        for (char c = 0; c < inDegree.length; c++) {    // 添加所有入度为0的点
            if (inDegree[c] != -1) {
                count++;
            }
            if (inDegree[c] == 0) {
                deque.addLast(c);
            }
        }
        while (!deque.isEmpty()) {
            Character src = deque.removeFirst();
            sb.append(src);

            if (map.containsKey(src)) {
                Set<Character> dstSet = map.get(src);
                for (Character dst : dstSet) {
                    inDegree[dst]--;
                    if (inDegree[dst] == 0) {
                        deque.addLast(dst);
                    }
                }
            }
        }
        return sb.length() != count ? "" : sb.toString();
    }

}
