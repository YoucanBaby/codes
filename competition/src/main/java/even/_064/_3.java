package even._064;

import java.util.HashMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._064
 * @author: xuyifang
 * @CreateTime: 2021-10-30-22:26
 * @description:
 * @version: 1.0
 */
public class _3 {

    public static void main(String[] args) {

    }


    public int[] platesBetweenCandles(String s, int[][] queries) {
        int N = queries.length;
        // 先算出每个范围内的盘子数
        int stickNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                stickNum++;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();    // <开始位置, 盘子总数>
        int index = 0;
        while (index < N) {
            if (s.charAt(index) == '|') {
                break;
            }
            index++;
        }
        int count = 0;
        for (int i = index; i < N; i++) {
            if (s.charAt(i) == '|') {
                map.put(i, count);
            } else {
                count++;
            }
        }

        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            String s1 = s.substring(queries[i][0], queries[i][1]);

            int left = s1.indexOf('|');
            int right = s1.lastIndexOf('|');
            if (left >= right) {
                continue;
            }

            int begin = queries[i][0] + left;
            int end = queries[i][0] + right;
            int beginNum = map.getOrDefault(begin, 0);
            int endNum = map.getOrDefault(end, 0);
            res[i] = endNum - beginNum;
        }
        return res;
    }
}
