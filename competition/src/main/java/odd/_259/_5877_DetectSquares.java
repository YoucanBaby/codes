package odd._259;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._259
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 10:41
 * @Description:
 */
public class _5877_DetectSquares {

    public static void main(String[] args) {
        DetectSquares solution = new DetectSquares();
        System.out.println(solution.test(1,2));
    }

    // 思路：枚举所有的点，找是否存在对角线，有对角线存在就把三个点的值乘起来
    static class DetectSquares {

        Map<Integer, Integer> map = new HashMap<>();
        int[] p = new int[] {1,1};;
        int[] p0 = new int[] {1,1};
        int[] p1 = new int[] {1,1};;
        int[] p2 = new int[] {1,1};;
        int[] p3 = new int[] {1,1};;
        int x = 1;
        int y = 10;

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public int hashCode() {
            return x * 10000 + y;
        }

        public DetectSquares() {

        }

        public boolean test(int x, int y) {
            return p0.equals(p1);
        }

        public void add(int[] p) {
            int key = getKey(p[0], p[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        public int count(int[] p) {
            int x = p[0], y = p[1];
            int res = 0;
            for (int key : map.keySet()) {
                int x1 = key / 10000;
                int y1 = key % 10000;
                if (Math.abs(x1 - x) == Math.abs(y1 - y) && x1 != x) {
                    int key2 = getKey(x1, y);
                    int key3 = getKey(x, y1);
                    if (!map.containsKey(key2) || !map.containsKey(key3)) continue;
                    res += map.get(key) * map.get(key2) * map.get(key3);
                }
            }
            return res;
        }

        private int getKey(int x, int y) {
            return x * 10000 + y;
        }
    }
}
