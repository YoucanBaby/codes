package data.hashtable1;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-07-25 09:54
 * @Description:
 */
public class _1743_restoreArray {

    public static void main(String[] args) {
        int[][] adjacentPairs = {
                {2,1}, {3,4}, {3,2}
        };
        _1743_restoreArray solution = new _1743_restoreArray();

        int[] res = solution.restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(res));
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : adjacentPairs) {
            if (!map.containsKey(a[0])) {
                map.put(a[0], new ArrayList<>());
            }
            if (!map.containsKey(a[1])) {
                map.put(a[1], new ArrayList<>());
            }
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }

        int N = adjacentPairs.length;
        int[] res = new int[N + 1];
        int index = 0;
        Set<Integer> set = new HashSet<>();     // 控制元素的重复访问
        // 找大小为1的端点
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                res[index++] = key;
                set.add(key);
                break;
            }
        }

        while (index < N + 1) {
            int key = res[index - 1];
            for (int value : map.get(key)) {
                if (!set.contains(value)) {
                    res[index++] = value;
                    set.add(value);
                    break;
                }
            }
        }

        return res;
    }
}
