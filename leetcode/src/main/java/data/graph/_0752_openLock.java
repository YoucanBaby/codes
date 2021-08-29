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


    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] ds = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(solution.openLock(ds, target));
    }

    static class Solution {
        public int openLock(String[] ds, String target) {
            Set<String> deadend = new HashSet<>();
            for (String d : ds) {
                deadend.add(d);
            }

            if (deadend.contains("0000")) {
                return -1;
            }
            if (target.equals("0000")) {
                return 0;
            }

            Deque<String> deque = new ArrayDeque<>();
            Map<String, Integer> dist = new HashMap<>();    // <转盘锁上的数字，最短路径>
            deque.addLast("0000");
            dist.put("0000" , 0);

            while (!deque.isEmpty()) {
                String cur = deque.removeFirst();
                List<String> nextList = getNext(cur);

                for (String next : nextList) {
                    // 如果当前数字不是死亡数字，并且之前没有访问过这个数字
                    if (!deadend.contains(next) && !dist.containsKey(next)) {
                        dist.put(next, dist.get(cur) + 1);
                        deque.addLast(next);

                        if (next.equals(target)) {
                            return dist.get(next);
                        }
                    }
                }
            }
            return -1;
        }

        private List<String> getNext(String cur) {
            List<String> nextList = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                // 加1
                char[] next = cur.toCharArray();
                next[i] = next[i] == '9' ? '0' : (char) (next[i] + 1);
                nextList.add(new String(next));
                // 减1
                next = cur.toCharArray();
                next[i] = next[i] == '0' ? '9' : (char) (next[i] - 1);
                nextList.add(new String(next));
            }
            return nextList;
        }
    }
}
