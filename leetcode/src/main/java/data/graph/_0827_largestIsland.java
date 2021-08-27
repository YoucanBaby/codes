package data.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-27 02:50
 * @Description:
 */
public class _0827_largestIsland {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {
                {1,1}, {1,0}
        };

        System.out.println(solution.largestIsland(mat));
    }

    static class Solution {
        int[][] dirs = {
                {-1, 0}, {1, 0},    // 上下
                {0, -1}, {0 , 1}    // 左右
        };

        int[][] mat;
        int M;
        int N;

        public int largestIsland(int[][] mat) {
            this.mat = mat;
            M = mat.length;
            N = mat[0].length;

            int res = 0;
            int index = 2;
            Map<Integer, Integer> indexAndAreas = new HashMap<>();
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (mat[x][y] == 1) {
                        int area = getArea(x, y, index);
                        indexAndAreas.put(index, area);
                        index++;
                        res = Math.max(res, area);
                    }
                }
            }
            if (res == 0) {
                return 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (mat[x][y] == 0) {       //遍历海洋格子
                        Set<Integer> set = findNeighbour(x, y);
                        if (!set.isEmpty()) {
                            int twoIsland = 1;
                            for (int i : set) twoIsland += indexAndAreas.get(i);
                            res = Math.max(res, twoIsland);
                        }
                    }
                }
            }
            return res;
        }

        private HashSet<Integer> findNeighbour(int x, int y) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int dir[] : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (inArea(nextX, nextY) && mat[nextX][nextY] != 0) {
                    hashSet.add(mat[nextX][nextY]);
                }
            }
            return hashSet;
        }

        private int getArea(int x, int y, int index) {
            if (!inArea(x, y)) {
                return 0;
            }

            int count = 0;
            if (mat[x][y] == 1) {
                mat[x][y] = index;
                count++;
                for (int[] dir : dirs) {
                    count += getArea(x + dir[0], y + dir[1], index);
                }
            }
            return count;
        }

        private boolean inArea(int x, int y) {
            return 0 <= x && x < M && 0 <= y && y < N;
        }
    }
}
