package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-11 22:03
 * @Description:
 */
public class _0752_openLock {

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }

        // 处理特殊情况
        if (set.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }

        // BFS
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("0000");
        Map<String, Integer> map = new HashMap<>();
        map.put("0000", 0);

        while (!deque.isEmpty()) {
            String cur = deque.removeFirst();
            // 生成cur的下一个节点
            List<String> nexts = createNext(cur);

            for (String next : nexts) {
                // 如果当前节点不是死亡数字 并且 map中没有这个节点
                if (!set.contains(next) && !map.containsKey(next)) {
                    deque.addLast(next);
                    map.put(next, map.get(cur) + 1);
                    if (next.equals(target)) {
                        return map.get(next);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> createNext(String cur) {
        List<String> nexts = new ArrayList<>();
        char[] arr = cur.toCharArray();

        for (int i = 0; i < 4; i++) {
            char c = arr[i];
            // 第i位+1
            int temp = cur.charAt(i) - '0' + 1;
            temp %= 10;
            arr[i] = (char) ('0' + temp);
            nexts.add(new String(arr));
            arr[i] = c;

            // 第i位-1
            temp = cur.charAt(i) - '0';
            if (temp == 0) {
                temp = 10;
            }
            temp--;
            arr[i] = (char) ('0' + temp);
            nexts.add(new String(arr));
            arr[i] = c;
        }

        return nexts;
    }

}
